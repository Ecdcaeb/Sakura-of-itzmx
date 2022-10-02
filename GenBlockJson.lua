local outFile = nil;
local modName = "itzmx";
local blockName = "grid_normal";

local function GenModelBlockItem()
	local path = string.format("src\\main\\resources\\assets\\%s\\models\\item\\%s.json", modName, blockName);
	outFile = io.open(path,"w");
	outFile:write('{\n');
	local content = string.format("\t\"parent\": \"%s:block/%s\"\n", modName,blockName );
	outFile:write(content);
	outFile:write('}\n');
	outFile:close();
end

local function GenModelBlock()
	local path = string.format("src\\main\\resources\\assets\\%s\\models\\block\\%s.json", modName, blockName);
	outFile = io.open(path,"w");
	outFile:write('{\n');
	outFile:write('\t\"parent\": \"block/cube_all\",\n');
	outFile:write('\t\"textures\": {\n');
	local content = string.format("\t\t\"all\": \"%s:blocks/%s\"\n", modName,blockName );
	outFile:write(content);
	outFile:write('\t}\n');
	outFile:write('}\n');
	outFile:close();
end

local function GenBlockState()
	local path = string.format("src\\main\\resources\\assets\\%s\\blockstates\\%s.json", modName, blockName);
	outFile = io.open(path,"w");
	outFile:write('{\n');
	outFile:write('\t\"variants\": {\n');
	local content = string.format("\t\t\"normal\": { \"model\": \"%s:%s\" }\n", modName,blockName );
	outFile:write(content);
	outFile:write('\t}\n');
	outFile:write('}\n');
	outFile:close();
end

local function GenBlock(_blockName)
	blockName = _blockName;
	print("Creating:"..blockName)
	GenModelBlockItem();
	GenModelBlock();
	GenBlockState();
end




local function GenItem(_typeName, _itemName, _HoldingType)
	print("Creating:".._typeName.." ".._itemName.." " .._HoldingType)
	local path = string.format("src\\main\\resources\\assets\\%s\\models\\item\\%s.json", modName, _itemName);
	outFile = io.open(path,"w");

	local content = string.format('{"parent": "item/%s","textures": {"layer0":"%s:items/%s/%s"}}\n', _HoldingType ,modName, _typeName, _itemName );
	outFile:write(content);

	outFile:close();
end

-- creat item
 GenItem("misc", "item_rainbow","generated");
 GenItem("misc", "item_blood_rainbow","generated");
 GenItem("misc", "item_rainbowj","handheld");
 GenItem("misc", "item_rainbow_cb","generated");
 GenItem("misc", "item_rainbow_normal_cb","generated");

 GenItem("misc", "item_food_mif","generated");
 GenItem("misc", "item_food_mif_uneatable","generated");
 GenItem("misc", "item_foodm_mf","generated");
 GenItem("misc", "item_foodm_ch","generated");
 GenItem("misc", "item_foodm_hy","generated");
 GenItem("misc", "item_hellosakura","generated");
 GenItem("misc", "item_sakura_itzmx","generated");
 GenItem("misc", "item_card_zfp","generated");
 GenItem("misc", "item_copyer","generated");
 GenItem("misc", "diamond_pickaxe","handheld");

 GenItem("misc", "item_emc","generated");

 GenItem("misc", "item_card_null","generated");
 GenItem("misc", "item_card_get_from_null","generated");

 GenItem("misc", "item_main_xk","generated");
 GenItem("misc", "item_main_tr","generated");
 GenItem("misc", "item_main_sy","generated");
 GenItem("misc", "item_main_wj","generated");

 GenItem("misc", "item_main_null","generated");

--create block

 GenBlock("block_rainbow");
 GenBlock("block_worldsakurawa");
 --GenBlock("block_infinitycake");
--GenBlock("block_enchantment_table");
--GenBlock("block_bitdo");
--GenBlock("block_bitplanet");--the block need be created specially.
--GenBlock("block_worldsakura");


--GenBlock("idl_glass");

-- GenItem("misc", "nano_mender_greater");
-- GenItem("misc", "package_fade_armor_diamond");
-- for i = 1,4 do 
-- 	GenItem("misc", "armor_qsh_"..i);
-- end

-- for i = 1,4 do 
-- 	GenItem("misc", "mor_armor_"..i);
-- end
--GenBlock("builder_farm_sin");
--GenBlock("de_water_orb");

--GenItem("misc", "water_extractor")
--GenItem("misc", "disturb_measure")
--GenItem("skill", "skill_radar_creature")
-- GenItem("skill", "clone_block")

-- for i = 1,4 do 
-- 	GenItem("armor", "l_m_armor_" .. i)
-- end
