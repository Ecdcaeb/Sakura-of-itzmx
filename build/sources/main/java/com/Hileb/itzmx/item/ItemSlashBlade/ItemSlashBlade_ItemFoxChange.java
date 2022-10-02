package com.Hileb.itzmx.item.ItemSlashBlade;



//    @SubscribeEvent
//    public void init(LoadEvent.InitEvent event){
//        ItemSlashBlade.specialAttacks.put(Integer.valueOf(100),new SlashDimension());                 //SA
//        String name="slashBlade.foxchange.name";                                                      //lang名字
//        ItemStack customblade=new ItemStack(SlashBlade.bladeNamed,1,0);                //物品架
//        NBTTagCompound tag =new NBTTagCompound();                                                    //刀的nbt
//        customblade.setTagCompound(tag);                                                             //
//        ItemSlashBladeNamed.CurrentItemName.set(tag,name);//屬性刀名
//        ItemSlashBladeNamed.CustomMaxDamage.set(tag,Integer.valueOf(133));//属性耐久
//        ItemSlashBlade.AttackAmplifier.set(tag,4.0F);//攻击倍速
//        ItemSlashBladeNamed.IsDefaultBewitched.set(tag,true);//是否为妖刀
//        ItemSlashBlade.setBaseAttackModifier(tag,4.0F);//初始攻击力
//        ItemSlashBlade.TextureName.set(tag,"");//贴图位置
//        ItemSlashBlade.ModelName.set(tag,"");//模型位置
//        ItemSlashBlade.SpecialAttackType.set(tag,Integer.valueOf(100));//攻击类型，同SA
//        ItemSlashBlade.StandbyRenderType.set(tag,Integer.valueOf(3));
//        GameRegistry.registerCustomItemStack;//注册
//        ItemSlashBladeNamed.NamedBlades.add(name);//注册
//        ItemStack custombladeReqired=new ItemStack(SlashBlade.weapon);//合成项
//        NBTTagCompound regTag=ItemSlashBlade.getItemTagCompound(custombladeReqired);//合成项
//        ItemSlashBlade.KillCount.set(regTag,Integer.valueOf(100));//合成项
//        ItemSlashBlade.ProudSoul.set(regTag,Integer.valueOf(500));//合成项
//        ItemStack louguan = GameRegistry.findRegistry(new IForgeRegistryEntry);
//        ItemStack itemSphereBladeSoul = GameRegistry.findRegistry("flammpfeil.slashblade");
//        ItemStack ingot = GameRegistry.findRegistry("flammpfeil.slashblade");
//        SlashBlade.addRecipe((name,new RecipeAwakeBlade(louguan,custombladeReqired),new Object()));//合成
//        AchievementList.registerAchievement(name,customblade,null);//成就
//
//
//
//
//    }