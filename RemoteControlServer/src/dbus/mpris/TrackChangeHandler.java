package dbus.mpris;

import java.util.HashMap;
import java.util.Map;

import org.freedesktop.MediaPlayer;
import org.freedesktop.MediaPlayer.TrackChange;
import org.freedesktop.dbus.DBusSigHandler;

import server.Server;

import commands.CommandWord;
import commands.MetaDataCommand;

public class TrackChangeHandler implements DBusSigHandler<MediaPlayer.TrackChange> {
	Server server;
	
	public TrackChangeHandler(Server s) {
		server = s;
	}
	
	@Override
	public void handle(TrackChange tc) {
		System.out.println("Sending command track_changed to client");
		MetaDataCommand c = new MetaDataCommand(CommandWord.TRACK_CHANGED);
		Map<String, String> map = new HashMap<String, String>(tc.METADATA.size());
		for(String key : tc.METADATA.keySet()) {
			map.put(key, tc.METADATA.get(key).getValue().toString());
		}
		c.setMetaData(map);
		server.sendCommand(c);
	}
}