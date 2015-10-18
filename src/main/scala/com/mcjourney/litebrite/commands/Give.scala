package com.mcjourney.litebrite.commands

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

import scala.collection.JavaConversions._

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of lightbright.
 * 
 * lightbright can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

object Give {

  private val _item: ItemStack = {
    val itemS = new ItemStack(Material.STICK)
    val itemM = itemS.getItemMeta
    itemM.setLore(seqAsJavaList(List("LiteBrite")))
    itemS.setItemMeta(itemM)
    itemS
  }

  def item = _item

  def apply(player: Player): Unit ={
    player.getInventory.addItem(item)
  }
}
