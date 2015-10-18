package com.mcjourney.litebrite.commands

import com.mcjourney.litebrite.LiteBrite
import com.mcjourney.litebrite.storage.LightStore
import com.mcjourney.litebrite.utils.BlockLoc

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of lightbright.
 * 
 * lightbright can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object Remove {
  def apply(loc: BlockLoc): Unit = {
    if(LightStore.has(loc)) {
      val registry = LiteBrite.instance.lightRegistry
      registry.deleteLight(loc.location)
      registry.sendChunks(registry.collectChunks(loc.location))
      LightStore.remove(loc)
    }
  }

  def apply(index: Int): Unit ={
    if(LightStore.size > index) {
      val registry = LiteBrite.instance.lightRegistry
      val loc = LightStore.get(index)
      registry.deleteLight(loc.location)
      registry.sendChunks(registry.collectChunks(loc.location))
      LightStore.remove(loc)
    }
  }

}
