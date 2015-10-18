package com.mcjourney.litebrite.commands

import com.mcjourney.litebrite.LiteBrite
import com.mcjourney.litebrite.storage.LightStore
import com.mcjourney.litebrite.utils.BlockLoc
import org.bukkit.entity.Player
import ru.BeYkeRYkt.LightAPI.LightRegistry

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of lightbright.
 * 
 * lightbright can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object Create {
  def apply(blockLoc: BlockLoc): Unit ={
    val registry = LiteBrite.instance.lightRegistry
    registry.createLight(blockLoc.location, 15)
    registry.sendChunks(registry.collectChunks(blockLoc.location))
    LightStore.add(blockLoc)
  }
}
