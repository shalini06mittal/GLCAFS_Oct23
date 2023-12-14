package com.annotations;

/**
 * name of planets
 * rainbow colors
 * days of the week
 * 
 * 
 * @author Shalini
 *
 */
public class NativeMethods {

	@OSystem(ostype = OSType.WINDOWS) // OS name
	public void m1() {
		// windows
	}
	@OSystem(ostype = OSType.MAC) //
	public void m2() {
		// MAC
	}
}
