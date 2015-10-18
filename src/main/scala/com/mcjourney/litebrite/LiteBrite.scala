package com.mcjourney.litebrite

import com.mcjourney.litebrite.commands.CmdDistributor
import com.mcjourney.litebrite.listeners.ClickListener
import com.mcjourney.litebrite.storage.LightStore
import org.bukkit.plugin.java.JavaPlugin
import ru.BeYkeRYkt.LightAPI.{LightAPI, LightRegistry}

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of lightbright.
 * 
 * lightbright can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class LiteBrite extends JavaPlugin{

  private var _lightRegistry: LightRegistry = null

  def lightRegistry = _lightRegistry

  override def onEnable(): Unit ={
    LiteBrite._instance = this
    _lightRegistry = LightAPI.getRegistry(this)
    getServer.getPluginCommand("litebrite").setExecutor(new CmdDistributor)
    getServer.getPluginManager.registerEvents(new ClickListener, this)
  }

  override def onDisable(): Unit ={
    for(light <- LightStore.values){
      _lightRegistry.deleteLight(light.location)
      _lightRegistry.sendChunks(_lightRegistry.collectChunks(light.location))
    }
    //Why am I deconstructing? Because memory leaks aren't fun >:C
    LiteBrite._instance = null
    _lightRegistry = null
  }

}

object LiteBrite{
  private var _instance: LiteBrite = null
  def instance: LiteBrite = _instance
}