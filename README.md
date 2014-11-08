L2J-YANBuffer  
=============  
  
=================================  
Powered By FBIagent - L2jServer  
=================================  
  
Features of latest version  
==========================  
  
Flexible buff cost configuration.  
柔軟なバフコストな構成。  
Support for enchanted skills.  
エンチャントスキルのサポート  
Support for duplicate skills with different enchant routes.  
別のエンチャントルートと重複したスキルのサポート  
Support for buff categories.  
バフのカテゴリのサポート  
Support for voiced command and NPC.  
有声コマンドとNPCのサポート  
Support to open the voiced buffer with item.  
アイテムと有声バッファを開くためにサポートしています。  
Support for multiple buffer NPCs with different buff categories.  
異なるバフカテゴリを持つ複数のバッファのNPCのサポート  
Support for player unique bufflists(create from current buffs and manually).  
プレイヤーユニークbufflistsサポート（手動で現在存在しているのバフから作成できる）  
Support to heal and calcel buffs.  
癒すためにサポートとcalcelバフ  
Support to buff/heal/cancel your current companion(pet & servitor).  
バフへのサポート/あなたの現在のコンパニオンをキャンセル/癒す（ペット＆召喚獣）  
Support for community board and npc window.  
コミュニティボードとNPCウィンドウのサポート。  
Custom template engine to generate htmls.  
カスタムテンプレートエンジンはHTML群を生成する 
Support for preset bufflists. Players can use this if they don't want to create a unique bufflist.  
元からセットされたbufflistsのサポート。ユニークなbufflistを作成しない場合は、プレイヤーはこれを使用することができます
Thanks To  
JMD - Example XML data for buffs.xml, buff_categories.xml, voiced_buffer.xml and npc_buffers.xml  


=================================
Edit by T-Dat0r - L2jServer
=================================





=================================
Setup Guide
=================================
XML Configuration  
Use a validating editor to edit the xml files, it will validate the files with the shipped xsd files.  
The pack is shipped with example XML configurations which should make everything self explanatory.  
1. Configure dialog type and heal cooldown in yanbuffer.xml.  
2. Define item requirements in item_requirements.xml.  
3. Define buffs in buffs.xml. The buffs can have multiple items for it's payment fee.  
4. Define buff categories in buff_categories.xml. The categories can have multiple buffs specified.  
5. Define buff npcs in buffer_npcs.xml. The npcs can have multiple buff categories.  
5. Configure the voiced buffer in voiced_buffer.xml. The voiced buffer can have multiple buff categories.  
Database  
For the unique bufflist(sometimes also called buff schemas) you need to execute the game.sql in your gameserver database.  
Custom NPCs  
You need to create custom npc's with the id specified for the npcs in buffer_npcs.xml.  
Voiced Buffer  
Your players can open the voiced buffer by using .yanbuffer in normal(white) chat.  
To get the voiced buffer working with an item, you need to add <set name="handler" val="YANBufferItemHandler"/> to the xml of the item which should open the voiced buffer.  
I tested this with Adena, and when i tried to use it, the voiced buffer opened.  
Make it load  
Add YANModPack/YANBuffer/YANBuffer.java to your scripts.cfg.  
Preset Bufflists  
You create usual buff categories in buff_categories.java. In the buffer_npcs.xml or voiced_buffer.xml you now have to set is_preset=true on the category you want to have as preset bufflist.  
  
  
=================================
Version History  
=================================

==========
Version 1:
==========
First public release.  
Can apply the effects of any skills to players.  
Support for a unique bufflist(scheme) per player.  
  
==========
Version 2:
==========
Support for multiple unique bufflists(schemas) added(cretae/delete/edit).  

==========
Version 3:
==========
Support for voiced command buffer. With ".yanb" you can open the voiced command buffer. See voiced_buffer.xml for configurations, it's like a single buffer npc.  
Support to heal and cancel  
Support to buff, heal or cancel your current companion(summon, pet, etc.)  
Html template variables has changed to support voiced and npc bypasses in one html, old htmls will not work for this version.  

===================
Version 3 Update 1:
===================
Prevent using the voiced buffer in the folowing situations:  
Inside zones: Jail, PvP, Siege, Danger Area, Water  
In state: has karma, has pvp flag, is in duell  
In events: Event, Block Checker, TvT  

===================
Version 3 Update 2:  
===================
Extended the html template engine to be able to hide buffs already on the players bufflist.  
Folder structure changed. From now on all YANxxxx mods reside in game/data/scripts/YANModPack.  
Changed voiced command from ".yanb" to ".yanbuffer"!  

===================
Version 3 Update 3:  
===================
Fixed voice command placement on html.  

===================
Version 3 Update 4:
===================
Fixed registering npc ai and voiced command handler when data loading fails.  

==========
Version 4:
==========
Added support for small and community dialog style(configurable in yanbuffer.xml).  
Added configurable heal cooldown value(configurable in yanbuffer.xml).  
Bypasses have changed, htmls for this version are not compatible with old versions.  

===================
Version 4 Update 1:  
===================
Fixed olympiad resriction for voiced buffer.  
Fixed html template engine to retain placeholder insert order.  
Fixed for unique bufflist, category, buff and item order on html.  
Added support to open the voiced buffer by item.  

===================
Version 4 Update 2:
===================
Fixed using buffer while in combat.  
Added limit for number of unique bufflists per player (yanbuffer.xml).  
Added limit for buffs/songs/dances per unique bufflist (yanbuffer.xml).  
Improoved community board dialogs.  
Added versions for HighFive unstable AND stable.  

==========
Version 5:
==========
Removed first talk htmls.  
Now using a custom bypass implementation.  
Added option for requried item in inventory to use the voiced buffer (voiced_buffer.xml)  
Added functionality that a player can create a unique bufflist by the buffs the player has.  
Added functionality to create preset bufflists. A player can use this bufflists directly without creating their own.  
The example preset bufflists in buff_categories.xml (BC_FIGHTER & BC_MAGE) are just examples, you have to put the proper buffs into that category yourself.  

===================
Version 5 Update 1:
===================
Fixed wrong buff category identifier on npc/main.html  
Added propper buffs to the preset bufflists BC_FIGHTER and BC_MAGE(made by JMD, thanks)  

===================
Version 5 Update 2:
===================
Fixed npc bypass problem ------- [L2PcInstance] player [......] sent invalid bypass 'YANBufferNpc YANBufferNpc .....'.  

===================
Version 5 Update 3:
===================
Removed dependency on preset_bufflists.xml, it was never used and was just a leftover from trying how to do it good.  
Addressed problems with BETA problems. Now you are able to use the npc buffer again. (In BETA, due to Html action cache changes, it's currently not possible to use the community style with an npc).  
