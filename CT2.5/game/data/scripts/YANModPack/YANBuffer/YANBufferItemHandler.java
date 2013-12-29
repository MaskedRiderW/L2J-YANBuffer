/*
 * Copyright (C) 2004-2013 L2J DataPack
 * 
 * This file is part of L2J DataPack.
 * 
 * L2J DataPack is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * L2J DataPack is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package YANModPack.YANBuffer;

import com.l2jserver.gameserver.handler.IItemHandler;
import com.l2jserver.gameserver.model.L2ItemInstance;
import com.l2jserver.gameserver.model.L2Object.InstanceType;
import com.l2jserver.gameserver.model.actor.L2Playable;
import com.l2jserver.gameserver.model.actor.instance.L2PcInstance;

/**
 * @author FBIagent
 */
public final class YANBufferItemHandler implements IItemHandler
{
	private static final class SingletonHolder
	{
		protected static final YANBufferItemHandler INSTANCE = new YANBufferItemHandler();
	}
	
	static YANBufferItemHandler getInstance()
	{
		return SingletonHolder.INSTANCE;
	}
	
	YANBufferItemHandler()
	{
	}
	
	@Override
	public void useItem(L2Playable playable, L2ItemInstance item, boolean forceUse)
	{
		if (!playable.isInstanceType(InstanceType.L2PcInstance))
		{
			return;
		}
		
		YANBuffer.getInstance().executeCommand((L2PcInstance) playable, null, null);
	}
}
