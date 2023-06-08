package utilities;

import org.bukkit.inventory.ItemStack;

public class GetHead {

    public static ItemStack getHead(ItemStack item, String id, String texture) {
        net.minecraft.server.v1_8_R3.ItemStack head = org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.asNMSCopy(item);
        net.minecraft.server.v1_8_R3.NBTTagCompound tag = head.hasTag() ? head.getTag() : new net.minecraft.server.v1_8_R3.NBTTagCompound();
        net.minecraft.server.v1_8_R3.NBTTagCompound skullOwnerCompound = new net.minecraft.server.v1_8_R3.NBTTagCompound();
        net.minecraft.server.v1_8_R3.NBTTagCompound properties = new net.minecraft.server.v1_8_R3.NBTTagCompound();


        net.minecraft.server.v1_8_R3.NBTTagList texturas = new net.minecraft.server.v1_8_R3.NBTTagList();
        net.minecraft.server.v1_8_R3.NBTTagCompound texturasObjeto = new net.minecraft.server.v1_8_R3.NBTTagCompound();
        texturasObjeto.setString("Value", texture);
        texturas.add(texturasObjeto);
        properties.set("textures", texturas);
        skullOwnerCompound.set("Properties", properties);
        skullOwnerCompound.setString("Id", id);
        tag.set("SkullOwner", skullOwnerCompound);
        head.setTag(tag);


        return org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack.asBukkitCopy(head);
    }

}
