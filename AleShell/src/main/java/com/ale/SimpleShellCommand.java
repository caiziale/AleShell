 /*
 * Copyright 2022 the original author.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.springframework.stereotype.Component;

/**
* 
* @author caizi
*
*/
@Component
public class SimpleShellCommand {

	/**
	 * 
	 * @param shellCmdObject
	 * @return the value in String
	 */
	public String execShellCmd(String cmdStr,String charset) {
		if(charset.isEmpty())
			charset="UTF-8";
		
		String ss=null;
		BufferedReader bufferedReader=null;
		try {
			Process process=Runtime.getRuntime().exec(cmdStr);
			bufferedReader=new BufferedReader(new InputStreamReader(process.getInputStream(),Charset.forName(charset)));
						
			StringBuffer sb=new StringBuffer();
			String line=null;
			while ((line=bufferedReader.readLine())!=null) {
				System.out.println(line);			
				sb.append(line+"\n");				
			}
			ss=new String(sb.toString());
			//System.out.println(ss);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(bufferedReader!=null)
					bufferedReader.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ss;
	}
}