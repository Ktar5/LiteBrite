package com.mcjourney.litebrite.commands

import com.mcjourney.litebrite.storage.LightStore
import org.bukkit.entity.Player

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of lightbright.
 * 
 * lightbright can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object ListCmd {
  val PAGE_COUNT = 5

  def apply(player: Player, page: Int): Unit = {
    val maxPages = LightStore.size / PAGE_COUNT
    var index = PAGE_COUNT * (if (page <= 0) 0 else page - 1)
    var max = (PAGE_COUNT * (if (page <= 0) 0 else page - 1)) + PAGE_COUNT
    if (index > LightStore.size) {
      player.sendMessage("That page doesn't exist matey.. sorrz")
      return
    } else {
      player.sendMessage(s"Page $page of $maxPages")
    }
    while(index < LightStore.size && index <= max){
      val block = LightStore.get(index)
      player.sendMessage(s"$index > $block")
      index += 1
    }
  }

}
