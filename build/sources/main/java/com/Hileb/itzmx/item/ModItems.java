package com.Hileb.itzmx.item;

import com.Hileb.itzmx.init.ModCreativeTab;
import com.Hileb.itzmx.item.food.ItemFoodBase;
import com.Hileb.itzmx.item.weapon.*;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	//Basic


	public static final Item ITEM_RAINBOW = new ItemBase("item_rainbow");
	public static final Item ITEM_BLOOD_RAINBOW = new ItemBase("item_blood_rainbow");

	public static final Item ITEM_RAINBOW_CB = new ItemBase("item_rainbow_cb");
	public static final Item ITEM_RAINBOW_NORMAL_CB = new ItemBase("item_rainbow_normal_cb");

	public static final Item ITEM_FOODM_MF= new ItemBase("item_foodm_mf");
	public static final Item ITEM_FOODM_HY= new ItemBase("item_foodm_hy");
	public static final Item ITEM_FOODM_CH= new ItemBase("item_foodm_ch");

	public static final Item ITEM_FOOD_MIF= new ItemFoodBase("item_food_mif",0,0,false);
	public static final Item ITEM_FOOD_MIF_UN= new ItemBase("item_food_mif_uneatable",16);

	public static final Item ITEM_HELLOSAKURA= new ItemBase("item_hellosakura",null);

	public static final Item ITEM_SAKURA_ITZMX= new ItemAddSakura("item_sakura_itzmx", null,1);
	public static final Item ITEM_ADVANCEMENTS= new ItemBase("advancements", null,1);

	public static final Item ITEM_COPYER =new ItemCopier("item_copyer");
	public static final Item ITEM_CARD_ZFP =new ItemCardAddZFP("item_card_zfp", ModCreativeTab.IDL_MISC);

	public static final Item ITEM_EMC =new ItemEMC("item_emc");
	public static final Item ITEM_CARD_GET_FROM_NULL=new ItemCardGetFromNull();
	public static final Item ITEM_CARD_NULL=new ItemBase("item_card_null");



	public static final Item ITEM_RAINBOWJ = new ItemItzmxJ("item_rainbowj", ModToolMaterial.TOOL_MATERIAL_RAINBOW);
	public static final Item ITEM_AXE_DIA = new ItemAxeDiamond_();


	//public static final Item SlashBlade_ITZMX_RAINBOW = new ItemSlashBladeItzmx(TOOL_MATERIAL_RAINBOW,7f,"item_bdj_rainbow");
    public static final Item ITEM_MAIN_XK=new ItemBase("item_main_xk");
    public static final Item ITEM_MAIN_TR=new ItemBase("item_main_tr");
    public static final Item ITEM_MAIN_SY=new ItemBase("item_main_sy");
    public static final Item ITEM_MAIN_WJ=new ItemBase("item_main_wj");
    public static final Item ITEM_MAIN_NULL=new ItemBase("item_main_null");

    //public static final Item ITEM_RABBIT=new ItemBase("item_rabbbit");





	/*
	WOOD(0, 59, 2.0F, 0.0F, 15),
    STONE(1, 131, 4.0F, 1.0F, 5),
    IRON(2, 250, 6.0F, 2.0F, 14),
    DIAMOND(3, 1561, 8.0F, 3.0F, 10),
    GOLD(0, 32, 12.0F, 0.0F, 22);

    harvestLevel, maxUses, efficiency, damage, enchantability
	*/

	//Tool Material
//	public static final Item BLOOD_IRON_INGOT = new ItemBase("blood_iron_ingot");
//
//    public static final Item.ToolMaterial TOOL_MATERIAL_BLOOD =
//			EnumHelper.addToolMaterial("material_blood", 3, 512, 3.0F, 4F, 20).setRepairItem(new ItemStack( ModItems.BLOOD_IRON_INGOT));
//
//	public static final ItemKinshipSword KINSHIP_SWORD = new ItemKinshipSword("kinship_sword", TOOL_MATERIAL_BLOOD);

	//Armor
//    LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F),
//    CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F),
//    IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F),
//    GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F),
//    DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	//Note that if you want to set a mod thing as repair material, define them before the material, otherwise it will be empty.

//    public static final ItemArmor.ArmorMaterial moroonArmorMaterial = EnumHelper.addArmorMaterial(
//            "itzmx:armor_moroon", "itzmx:armor_moroon", 80, new int[] {3, 6, 8, 3}, 2, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2)
//            .setRepairItem(new ItemStack(Items.QUARTZ));
//

	//Food
//	static PotionEffect eff = new PotionEffect(MobEffects.LEVITATION, TICK_PER_SECOND * 60, 0);
//	public static final ItemFoodBase FIGHT_BREAD = (ItemFoodBase) new ItemFoodBase("war_bread", 10, 10, false).
//			setPotionEffect(eff, 1.0f).
//			setAlwaysEdible();
//    public static final ItemFoodBase MEMORY_BREAD = new ItemFoodBase("memory_bread", 3, 0.6f, false).SetXP(10);





	//Armor
//	public static final ItemHelmSniper helmetSniper = (ItemHelmSniper) new ItemHelmSniper("helmet_sniper", moroonArmorMaterialSniper, 1, EntityEquipmentSlot.HEAD);
//
//	public static final ItemArmorBase[] MOR_GENERAL_ARMOR =
//			{        new ItemArmorBase("mor_armor_1", moroonArmorMaterial, 1, EntityEquipmentSlot.HEAD)
//					,new ItemArmorBase("mor_armor_2", moroonArmorMaterial, 1, EntityEquipmentSlot.CHEST)
//					,new ItemArmorBase("mor_armor_3", moroonArmorMaterial, 1, EntityEquipmentSlot.LEGS)
//					,new ItemArmorBase("mor_armor_4", moroonArmorMaterial, 1, EntityEquipmentSlot.FEET)
//			};

	//public static final ItemSkillDecodeItem skillDecodeItem = (ItemSkillDecodeItem) new ItemSkillDecodeItem("skill_decode_item").setRarity(EnumRarity.RARE);

	//Package Example
//	public static final ItemPackage RANDOM_SKILL = (ItemPackage) new ItemPackage("random_skill", new Item[]{
//			Items.BLAZE_ROD, Items.PAPER
//	}).setMaxStackSize(1);
}
