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
        item = new ItemStack(351,1, (short) 8);
        meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);
        for(int i = 38; i < 43; i++) {
            inv.setItem(i, item);
        }
        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "f6db7588-352e-4074-86a8-4f58e2a8a74e", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTBhMTllMjNkMjFmMmRiMDYzY2M1NWU5OWFlODc0ZGM4YjIzYmU3NzliZTM0ZTUyZTdjN2I5YTI1In19fQ==");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&l1"));
        item.setItemMeta(meta);
        inv.setItem(12, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "517901d5-c5bc-4c07-a3f0-a0537d190f14", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2M1OTZhNDFkYWVhNTFiZTJlOWZlYzdkZTJkODkwNjhlMmZhNjFjOWQ1N2E4YmRkZTQ0YjU1OTM3YjYwMzcifX19");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&l2"));
        item.setItemMeta(meta);
        inv.setItem(13, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "b83b4f82-fad3-426f-a91d-e9325a5b39dd", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjg1ZDRmZGE1NmJmZWI4NTEyNDQ2MGZmNzJiMjUxZGNhOGQxZGViNjU3ODA3MGQ2MTJiMmQzYWRiZjVhOCJ9fX0=");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&l3"));
        item.setItemMeta(meta);
        inv.setItem(14, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "e3e876f9-2bc2-42a8-b480-4eaf0a00e803", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzg1MmEyNWZlNjljYTg2ZmI5ODJmYjNjYzdhYzk3OTNmNzM1NmI1MGI5MmNiMGUxOTNkNmI0NjMyYTliZDYyOSJ9fX0=");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&l4"));
        item.setItemMeta(meta);
        inv.setItem(21, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "c535d7f1-931e-4fab-a4f1-1f67e6ed868d", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzRlZTdkOTU0ZWIxNGE1Y2NkMzQ2MjY2MjMxYmY5YTY3MTY1MjdiNTliYmNkNzk1NmNlZjA0YTlkOWIifX19");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&l5"));
        item.setItemMeta(meta);
        inv.setItem(22, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "919f6697-ac07-41a2-90b4-1fc14c3afe48", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjY4MmEzYWU5NDgzNzRlMDM3ZTNkN2RkNjg3ZDU5ZDE4NWRkMmNjOGZjMDlkZmViNDJmOThmOGQyNTllNWMzIn19fQ==");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&l6"));
        item.setItemMeta(meta);
        inv.setItem(23, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "8b614d52-9a8c-4780-9f31-2021fc06aa4f", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGVhMzBjMjRjNjBiM2JjMWFmNjU4ZWY2NjFiNzcxYzQ4ZDViOWM5ZTI4MTg4Y2Y5ZGU5ZjgzMjQyMmU1MTAifX19");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&l7"));
        item.setItemMeta(meta);
        inv.setItem(30, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "ef959987-ff3f-44f5-8a0a-07ac776832fa", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjZhYmFmZDAyM2YyMzBlNDQ4NWFhZjI2ZTE5MzY4ZjU5ODBkNGYxNGE1OWZjYzZkMTFhNDQ2Njk5NDg5MiJ9fX0=");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&l8"));
        item.setItemMeta(meta);
        inv.setItem(31, item);

        item = new ItemStack(397,1,(short)3);
        item = GetHead.getHead(item, "fcc24a38-ef01-435a-a55d-e32451353e44", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGQ3OTEwZTEwMzM0Zjg5MGE2MjU0ODNhYzBjODI0YjVlNGExYTRiMTVhOTU2MzI3YTNlM2FlNDU4ZDllYTQifX19");
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&l9"));
        item.setItemMeta(meta);
        inv.setItem(32, item);

        item = new ItemStack(Material.ENDER_PEARL);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&9Reset PIN"));
        item.setItemMeta(meta);
        inv.setItem(49, item);

    }

    public static void setDecorationPass(Inventory inv, int actuallyNum) {
        int pos = 37 + actuallyNum;
        ItemStack item = new ItemStack(351,1, (short) 10);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2&k&lI"));
        item.setItemMeta(meta);
        inv.setItem(pos, item);
    }

    public static void resetDecorationPass(Inventory inv) {
        ItemStack item = new ItemStack(351,1, (short) 8);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);
        for(int i = 38; i < 43; i++) {
            inv.setItem(i, item);
        }
    }


}
