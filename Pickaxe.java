package com.uavxchallenge.me;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Pickaxe extends JavaPlugin implements Listener{

	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(label.equalsIgnoreCase("Titan")){
			if(!(sender instanceof Player)){
				sender.sendMessage(ChatColor.RED + "Only players can use that command!");
				return true;
			}
			Player player = (Player) sender;
			if(sender.hasPermission("Pick.Titan")){
				sender.sendMessage(ChatColor.GREEN + "Here is your " + ChatColor.AQUA + "Titan" + ChatColor.GREEN + " Pickaxe");
				
				ItemStack PA = new ItemStack(Material.DIAMOND_PICKAXE);
				ItemMeta PAmeta = PA.getItemMeta();
				
				PAmeta.setDisplayName(ChatColor.AQUA + "Titan");
				PA.setItemMeta(PAmeta);
				
				PA.addUnsafeEnchantment(Enchantment.DIG_SPEED, 20);
				PA.addUnsafeEnchantment(Enchantment.DURABILITY, 20);
				PA.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 20);
							
				ItemStack GS = new ItemStack(Material.DIAMOND_SWORD);
				ItemMeta GSmeta = GS.getItemMeta();
				
				GSmeta.setDisplayName(ChatColor.AQUA + "Sword of the Titans");
				GS.setItemMeta(GSmeta);
				
				GS.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 20);
				GS.addUnsafeEnchantment(Enchantment.DURABILITY, 20);
				GS.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 5);
				GS.addUnsafeEnchantment(Enchantment.KNOCKBACK, 15);
				GS.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 20);
				
				player.getInventory().addItem(PA);
				player.getInventory().addItem(GS);

                }else{
    				sender.sendMessage(ChatColor.RED + "You do not have the " + ChatColor.AQUA + "Titan" + ChatColor.RED + " Pickaxe");
    			}
				
		}
	return false;
	}

}

