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

package com.retroduction.carma.config;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.FactoryBean;
/**
 * helper class for reading a list of Files from a CSV string
 * @author mike
 *
 */
public class CSVFileListFactoryBean implements FactoryBean {
	private List<File> files;
	public Object getObject() throws Exception {
		return this.files;
	}

	public Class<List> getObjectType() {
		return List.class;
	}

	public boolean isSingleton() {
		return true;
	}

	
	public void setCsvNamesList(String csvFiles) throws MalformedURLException{
		String[] fileNames = csvFiles.split(",");
		List<File> filesList = new ArrayList<File>( fileNames.length);
		
		for(String f : fileNames){
			filesList.add( new File(f) );
			
		}
		this.files = filesList;
		
	}
}
