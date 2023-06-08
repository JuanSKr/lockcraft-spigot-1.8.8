package inv.modifier;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import utilities.GetHead;

public class LoginInventory {

    public static void fillInventory(Inventory inv) {
        ItemStack item = new ItemStack(160,1, (short) 15);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);

        for(int i = 0; i <= 8; i++) {
            inv.setItem(i, item);
        }
        for(int i = 45; i <= 53; i++) {
            inv.setItem(i, item);
        }
        inv.setItem(9, item);
        inv.setItem(18, item);
        inv.setItem(27, item);
        inv.setItem(36, item);
        inv.setItem(17, item);
        inv.setItem(26, item);
        inv.setItem(35, item);
        inv.setItem(44, item);
        item = new ItemStack(159,1, (short) 9);
        meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);
        for(int i = 38; i < 43; i++) {
            inv.setItem(i, item);
        }
        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "def59dbc-48b9-4946-acc8-e7e6fe078cb6", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDJhNmYwZTg0ZGFlZmM4YjIxYWE5OTQxNWIxNmVkNWZkYWE2ZDhkYzBjM2NkNTkxZjQ5Y2E4MzJiNTc1In19fQ==");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l1"));
        item.setItemMeta(meta);
        inv.setItem(12, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "6b397f14-e70a-4bcf-b9a1-8627f49b0580", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTZmYWI5OTFkMDgzOTkzY2I4M2U0YmNmNDRhMGI2Y2VmYWM2NDdkNDE4OWVlOWNiODIzZTljYzE1NzFlMzgifX19");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l2"));
        item.setItemMeta(meta);
        inv.setItem(13, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "9ce1a380-b1e9-4fdf-99f9-4f03ff82290c", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2QzMTliOTM0M2YxN2EzNTYzNmJjYmMyNmI4MTk2MjVhOTMzM2RlMzczNjExMWYyZTkzMjgyN2M4ZTc0OSJ9fX0=");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l3"));
        item.setItemMeta(meta);
        inv.setItem(14, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "c4777585-a4f4-4af6-848d-f3b384035048", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDE5OGQ1NjIxNjE1NjExNDI2NTk3M2MyNThmNTdmYzc5ZDI0NmJiNjVlM2M3N2JiZTgzMTJlZTM1ZGI2In19fQ==");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l4"));
        item.setItemMeta(meta);
        inv.setItem(21, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "600e2b9a-aca0-430b-9505-8cd89c9e1c94", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2ZiOTFiYjk3NzQ5ZDZhNmVlZDQ0NDlkMjNhZWEyODRkYzRkZTZjMzgxOGVlYTVjN2UxNDlkZGRhNmY3YzkifX19");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l5"));
        item.setItemMeta(meta);
        inv.setItem(22, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "1819d6a5-ce54-4cc9-83f7-79a4ed615974", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWM2MTNmODBhNTU0OTE4YzdhYjJjZDRhMjc4NzUyZjE1MTQxMmE0NGE3M2Q3YTI4NmQ2MWQ0NWJlNGVhYWUxIn19fQ==");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l6"));
        item.setItemMeta(meta);
        inv.setItem(23, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "40aefa88-fd07-42d1-9956-cd05b7d6b8bd", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWUxOThmZDgzMWNiNjFmMzkyN2YyMWNmOGE3NDYzYWY1ZWEzYzdlNDNiZDNlOGVjN2QyOTQ4NjMxY2NlODc5In19fQ==");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l7"));
        item.setItemMeta(meta);
        inv.setItem(30, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "0fec4608-939a-419f-90f5-b00ee1274945", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODRhZDEyYzJmMjFhMTk3MmYzZDJmMzgxZWQwNWE2Y2MwODg0ODlmY2ZkZjY4YTcxM2IzODc0ODJmZTkxZTIifX19");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l8"));
        item.setItemMeta(meta);
        inv.setItem(31, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "699e1fb2-6ba4-4004-b0e7-5ce8754c271a", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWY3YWEwZDk3OTgzY2Q2N2RmYjY3YjdkOWQ5YzY0MWJjOWFhMzRkOTY2MzJmMzcyZDI2ZmVlMTlmNzFmOGI3In19fQ==");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l9"));
        item.setItemMeta(meta);
        inv.setItem(32, item);

        item = new ItemStack(Material.REDSTONE_BLOCK);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cReset"));
        item.setItemMeta(meta);
        inv.setItem(49, item);

    }

    public static void setDecorationPass(Inventory inv, int actuallyNum) {
        int pos = 37 + actuallyNum;
        ItemStack item = new ItemStack(159,1, (short) 5);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);
        inv.setItem(pos, item);
    }

    public static void resetDecorationPass(Inventory inv) {
        ItemStack item = new ItemStack(159,1, (short) 9);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);
        for(int i = 38; i < 43; i++) {
            inv.setItem(i, item);
        }
    }


}
