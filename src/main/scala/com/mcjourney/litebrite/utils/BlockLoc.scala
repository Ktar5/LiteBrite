package com.mcjourney.litebrite.utils

import org.bukkit.{World, Location}

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of lightbright.
 * 
 * lightbright can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class BlockLoc(world: World, x: Int, y: Int, z: Int){
  def location = new Location(world, x,y,z)
  override def toString = world.getName + s" x:$x y:$y z:$z"

  override def equals(test: Any): Boolean ={
    test match {
      case loc: BlockLoc => loc.toString.equalsIgnoreCase(toString)
      case _ => false
    }
  }

}
object BlockLoc{
  def fromLoc(loc: Location): BlockLoc = new BlockLoc(loc.getWorld, loc.getBlockX, loc.getBlockY, loc.getBlockZ)
}
