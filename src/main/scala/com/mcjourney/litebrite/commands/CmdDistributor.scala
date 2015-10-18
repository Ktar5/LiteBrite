package com.mcjourney.litebrite.commands

import com.mcjourney.litebrite.utils.BlockLoc
import org.bukkit.command.{Command, CommandSender, CommandExecutor}
import org.bukkit.entity.Player

/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of lightbright.
 * 
 * lightbright can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

class CmdDistributor extends CommandExecutor{
  override def onCommand(sender: CommandSender, cmd: Command, something: String, args: Array[String]): Boolean = {
    sender match {
      //we foundsded the player!
      case player: Player =>
        //Match args
        args.length match {
          case 1 =>
            args(0).toLowerCase match {
              case "create" | "c" => Create(BlockLoc.fromLoc(player.getLocation))
              case "remove" | "r" => Remove(BlockLoc.fromLoc(player.getLocation))
              case "help" | "h" => Help(player)
              case "list" | "l" => ListCmd(player, 0)
              case "item" | "i" => Give(player)
              case _ => Help(player)
            }
          case 2 =>
            args(0).toLowerCase match {
              case "remove" | "r" => Remove(Integer.valueOf(args(1)))
              case "list" | "l" => ListCmd(player, Integer.valueOf(args(1)))
              case _ => Help(player)
            }
          case _ => Help(player)
        }
      case _ =>
        System.out.println("Im sorry... I can't let you do that :C")
    }
    false
  }
}
