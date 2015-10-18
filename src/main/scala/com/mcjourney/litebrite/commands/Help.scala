package com.mcjourney.litebrite.commands

import org.bukkit.entity.Player

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of lightbright.
 * 
 * lightbright can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object Help {
  def apply(player: Player): Unit ={
    player.sendMessage(Array(
      "/lb (create | c) - create a light at where youre looking",
      "/lb (remove | r) <index> - remove the light wher youre looking, or at <index>",
      "/lb (help | h) - take a wild F$%#ing guess",
      "/lb (list | l) <page> - list the first page or <page> of existing lights"
    ))
  }
}
