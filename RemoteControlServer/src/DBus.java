/**
 *
 * @author sourcemorph
 */

import org.freedesktop.dbus.DBusConnection;
import org.freedesktop.dbus.exceptions.DBusException;

abstract public class DBus {

	// dbus-send --print-reply --session --dest=org.mpris.vlc /Player
	// org.freedesktop.MediaPlayer.Pause

	protected String objectPath = "/Player";
	protected String serviceBusName = "org.mpris.vlc";
	protected static DBusConnection conn = null;

	public DBus() {
	}
	/**
	 * Start playing when stopped
	 * Pause when playing
	 * Play when in pause
	 */
	abstract public void togglePlayPause();
	/**
	 * Pause if playing, do nothing otherwise
	 */
	abstract public void pause();
	
	abstract public void next();

	abstract public void previous();

	abstract public void connect() throws DBusException;

	abstract public void disconnect();
}