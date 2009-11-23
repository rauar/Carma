/**
  *  This file is part of Carma (Retroduction.org).
  *
  *  Carma is free software: you can redistribute it and/or modify
  *  it under the terms of the GNU General Public License as published by
  *  the Free Software Foundation, either version 3 of the License, or
  *  (at your option) any later version.
  *
  *  Carma is distributed in the hope that it will be useful,
  *  but WITHOUT ANY WARRANTY; without even the implied warranty of
  *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  *  GNU General Public License for more details.
  *
  *  You should have received a copy of the GNU General Public License
  *  along with Carma.  If not, see <http://www.gnu.org/licenses/>.
  *
  * Copyright Retroduction.org (c) 2007-2010
  */
package com.retroduction.carma.utilities;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClassLoaderInfo {

	private static Log log = LogFactory.getLog(ClassLoaderInfo.class);

	public static void printLoader(Class<?> clazz) {
		log.info("Class: " + clazz);
		ClassLoader cl = clazz.getClassLoader();
		log.info("Loader: " + cl);
		StringBuffer s = new StringBuffer(" ");
		while ((cl = cl.getParent()) != null) {
			log.info(s + "" + cl);
			s.append("  ");
		}
	}

}
