/*     ____ ____  ____ ____  ______                                     *\
**    / __// __ \/ __// __ \/ ____/    SOcos COmpiles Scala             **
**  __\_ \/ /_/ / /__/ /_/ /\_ \       (c) 2002, LAMP/EPFL              **
** /_____/\____/\___/\____/____/                                        **
**                                                                      **
** $Id$
\*                                                                      */

package scalac.symtab.classfile;

import scalac.*;
import scalac.symtab.*;
import scalac.util.*;
import java.io.*;


public class SymblParser extends ClassParser {

    /** the global compilation environment
     */

    public SymblParser(Global global) {
	super(global);
    }
    /** complete class symbol c by loading the class
     */
    public void complete(Symbol c) {
	//System.out.println("loading " + c);//DEBUG
	try {
	    long msec = System.currentTimeMillis();
	    String filename = SourceRepresentation.externalizeFileName(
		c.fullName()) + ".symbl";
	    AbstractFile f = global.classPath.openFile(filename);
	    if (f == null)
		global.error("could not read class " + c);
	    else {
		byte[] data = f.read();
		new UnPickle(c, data, Name.fromString(filename));
		global.operation("loaded " + f.getPath() + " in " +
				 (System.currentTimeMillis() - msec) + "ms");
		//for (Definition e = c.locals().elems; e != null; e = e.sibling)
		//  if (e.def.kind == TYP)
                //      e.def.complete();
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	    global.error("i/o error while loading " + c);
	    c.setInfo(Type.ErrorType);
	    }
    }
}

