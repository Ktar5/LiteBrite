package com.mcjourney.litebrite.listeners

import com.mcjourney.litebrite.commands.{Create, Remove}
import com.mcjourney.litebrite.storage.LightStore
import com.mcjourney.litebrite.utils.BlockLoc
import org.bukkit.Material
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.{EventHandler, Listener}

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of lightbright.
 * 
 * lightbright can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class ClickListener extends Listener{

  @EventHandler
  def onClick(event: PlayerInteractEvent): Unit ={
    if(event.hasItem && event.hasBlock && event.getItem.getType.equals(Material.STICK) && event.getAction.toString.contains("RIGHT")){
      if(event.getItem.hasItemMeta && event.getItem.getItemMeta.hasLore && event.getItem.getItemMeta.getLore.get(0).equalsIgnoreCase("LiteBrite")){
        val blockloc = BlockLoc.fromLoc(event.getClickedBlock.getLocation)
        if(LightStore.has(blockloc)){
          Remove(blockloc)
        }else{
          Create(blockloc)
        }
      }
    }
  }

}
