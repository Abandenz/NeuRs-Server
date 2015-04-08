package server.model.items;

import server.Config;
import server.Server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Item {

    public static boolean[] itemStackable = new boolean[Config.ITEM_LIMIT];
    public static boolean[] itemIsNote = new boolean[Config.ITEM_LIMIT];
    public static int[] targetSlots = new int[Config.ITEM_LIMIT];

    static {
        int counter = 0;
        int c;

        try {
            FileInputStream dataIn = new FileInputStream(new File("./Data/data/stackable.dat"));
            while ((c = dataIn.read()) != -1) {
                if (c == 0) {
                    itemStackable[counter] = false;
                } else {
                    itemStackable[counter] = true;
                }
                counter++;
            }
            dataIn.close();
        } catch (IOException e) {
            System.out.println("Critical error while loading stackabledata! Trace:");
            e.printStackTrace();
        }

        counter = 0;

        try {
            FileInputStream dataIn = new FileInputStream(new File("./Data/data/notes.dat"));
            while ((c = dataIn.read()) != -1) {
                if (c == 0) {
                    itemIsNote[counter] = true;
                } else {
                    itemIsNote[counter] = false;
                }
                counter++;
            }
            dataIn.close();
        } catch (IOException e) {
            System.out.println("Critical error while loading notedata! Trace:");
            e.printStackTrace();
        }

        counter = 0;
        try {
            FileInputStream dataIn = new FileInputStream(new File("./Data/data/equipment.dat"));
            while ((c = dataIn.read()) != -1) {
                targetSlots[counter++] = c;
            }
            dataIn.close();
        } catch (IOException e) {
            System.out.println("Critical error while loading notedata! Trace:");
            e.printStackTrace();
        }
    }

    private static String[] fullbody = {
            "top", "chestplate", "shirt", "platebody", "Ahrims robetop",
            "Karils leathertop", "brassard", "Robe top", "robetop",
            "platebody (t)", "platebody (g)", "chestplate",
            "torso", "hauberk", "Dragon chainbody"
    };
    private static String[] fullhat = {
            "med helm", "coif", "Dharok's helm", "hood", "Initiate helm",
            "Coif", "Helm of neitiznot", "Armadyl helmet", "Berserker helm",
            "Archer helm", "Farseer helm", "Warrior helm", "Void"
    };
    private static String[] fullmask = {
            "full helm", "mask", "Verac's helm", "Guthan's helm", "Karil's coif", "mask", "Torag's helm", "sallet", "Saradomin helm",
    };

    public static boolean playerCape(int itemId) {
        String[] data = {
                "cloak", "cape", "ava's", "accumulator"
        };
        String item = getItemName(itemId);
        if (item == null) {
            return false;
        }
        boolean item1 = false;
        for (int i = 0; i < data.length; i++) {
            if (item.endsWith(data[i]) || item.contains(data[i])) {
                item1 = true;
            }
        }
        return item1;
    }

    public static boolean playerBoots(int itemId) {
        String[] data = {
                "Shoes", "shoes", "boots", "Boots"
        };
        String item = getItemName(itemId);
        if (item == null) {
            return false;
        }
        boolean item1 = false;
        for (int i = 0; i < data.length; i++) {
            if (item.endsWith(data[i]) || item.contains(data[i])) {
                item1 = true;
            }
        }
        return item1;
    }

    public static boolean playerGloves(int itemId) {
        String[] data = {
                "Gloves", "gloves", "glove", "Glove", "gauntlets", "Gauntlets", "vambraces", "vamb"
        };
        String item = getItemName(itemId);
        if (item == null) {
            return false;
        }
        boolean item1 = false;
        for (int i = 0; i < data.length; i++) {
            if (item.endsWith(data[i]) || item.contains(data[i])) {
                item1 = true;
            }
        }
        return item1;
    }

    public static boolean playerShield(int itemId) {
        String[] data = {
                "kiteshield", "book", "Kiteshield", "shield", "Shield", "Kite", "kite", "defender", "xil"
        };
        String item = getItemName(itemId);
        if (item == null) {
            return false;
        }
        boolean item1 = false;
        for (int i = 0; i < data.length; i++) {
            if (item.endsWith(data[i]) || item.contains(data[i])) {
                item1 = true;
            }
        }
        return item1;
    }

    public static boolean playerAmulet(int itemId) {
        String[] data = {
                "amulet", "Amulet", "necklace", "Necklace", "Pendant", "pendant", "Symbol", "stole", "symbol"
        };
        String item = getItemName(itemId);
        if (item == null) {
            return false;
        }
        boolean item1 = false;
        for (int i = 0; i < data.length; i++) {
            if (item.endsWith(data[i]) || item.contains(data[i])) {
                item1 = true;
            }
        }
        return item1;
    }

    public static boolean playerArrows(int itemId) {
        String[] data = {
                "Arrows", "arrows", "Arrow", "arrow", "Bolts", "bolts", "Bolt", "bolt"
        };
        String item = getItemName(itemId);
        if (item == null) {
            return false;
        }
        boolean item1 = false;
        for (int i = 0; i < data.length; i++) {
            if (item.endsWith(data[i]) || item.contains(data[i])) {
                item1 = true;
            }
        }
        return item1;
    }

    public static boolean playerRings(int itemId) {
        String[] data = {
                "ring", "rings", "Ring", "Rings",
        };
        String item = getItemName(itemId);
        if (item == null) {
            return false;
        }
        boolean item1 = false;
        for (int i = 0; i < data.length; i++) {
            if (item.endsWith(data[i]) || item.contains(data[i])) {
                item1 = true;
            }
        }
        return item1;
    }

    public static boolean playerHats(int itemId) {
        String[] data = {
                "boater", "cowl", "peg", "coif", "helm",
                "coif", "mask", "hat", "headband", "hood",
                "disguise", "cavalier", "full helm", "tiara",
                "helmet", "Hat", "ears", "partyhat", "helm(t)",
                "helm(g)", "beret", "facemask", "sallet",
                "hat(g)", "hat(t)", "bandana", "mitre", "Helm",
        };
        String item = getItemName(itemId);
        if (item == null) {
            return false;
        }
        boolean item1 = false;
        for (int i = 0; i < data.length; i++) {
            if ((item.endsWith(data[i]) || item.contains(data[i])) && itemId != 4214) {
                item1 = true;
            }
        }
        return item1;
    }

    public static boolean playerLegs(int itemId) {
        String[] data = {
                "tassets", "chaps", "bottoms", "gown", "trousers",
                "platelegs", "robe", "plateskirt", "legs", "leggings",
                "shorts", "Skirt", "skirt", "cuisse", "Trousers",
        };
        String item = getItemName(itemId);
        if (item == null) {
            return false;
        }
        boolean item1 = false;
        for (int i = 0; i < data.length; i++) {
            if ((item.endsWith(data[i]) || item.contains(data[i])) && (!item.contains("top") && (!item.contains("robe (g)") && (!item.contains("robe (t)"))))) {
                item1 = true;
            }
        }
        return item1;
    }

    public static boolean playerBody(int itemId) {
        String[] data = {
                "body", "top", "Priest gown", "apron", "shirt",
                "platebody", "robetop", "body(g)", "body(t)",
                "Wizard robe (g)", "Wizard robe (t)", "body", "brassard", "blouse",
                "tunic", "leathertop", "Saradomin plate", "chainbody",
                "hauberk", "Shirt", "torso", "chestplate",
        };
        String item = getItemName(itemId);
        if (item == null) {
            return false;
        }
        boolean item1 = false;
        for (int i = 0; i < data.length; i++) {
            if (item.endsWith(data[i]) || item.contains(data[i])) {
                item1 = true;
            }
        }
        return item1;
    }

    public static boolean isFullBody(int itemId) {
        String weapon = getItemName(itemId);
        if (weapon == null)
            return false;
        for (int i = 0; i < fullbody.length; i++) {
            if (weapon.endsWith(fullbody[i]) || weapon.contains(fullbody[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFullHelm(int itemId) {
        String weapon = getItemName(itemId);
        if (weapon == null)
            return false;
        for (int i = 0; i < fullhat.length; i++) {
            if (weapon.endsWith(fullhat[i]) && itemId != 2631) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFullMask(int itemId) {
        String weapon = getItemName(itemId);
        if (weapon == null)
            return false;
        for (int i = 0; i < fullmask.length; i++) {
            if (weapon.endsWith(fullmask[i]) && itemId != 2631) {
                return true;
            }
        }
        return false;
    }

    public static String getItemName(int id) {
        for (int j = 0; j < Server.itemHandler.ItemList.length; j++) {
            if (Server.itemHandler.ItemList[j] != null)
                if (Server.itemHandler.ItemList[j].itemId == id)
                    return Server.itemHandler.ItemList[j].itemName;
        }
        return null;
    }
}