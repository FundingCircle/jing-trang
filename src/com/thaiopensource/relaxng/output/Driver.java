package com.thaiopensource.relaxng.output;

import com.thaiopensource.relaxng.IncorrectSchemaException;
import com.thaiopensource.relaxng.edit.Pattern;
import com.thaiopensource.relaxng.edit.SchemaBuilderImpl;
import com.thaiopensource.relaxng.edit.SchemaCollection;
import com.thaiopensource.relaxng.parse.nonxml.NonXmlParseable;
import com.thaiopensource.relaxng.util.DraconianErrorHandler;
import com.thaiopensource.relaxng.util.ValidationEngine;
import org.relaxng.datatype.helpers.DatatypeLibraryLoader;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Driver {
  static public void main(String[] args) throws IncorrectSchemaException, SAXException, IOException {
    SchemaCollection sc = new SchemaCollection();
    Pattern p = SchemaBuilderImpl.parse(new NonXmlParseable(ValidationEngine.fileInputSource(args[0]),
                                                            new DraconianErrorHandler()),
                                        sc,
                                        new DatatypeLibraryLoader());
    XmlOutput.output(p, args[1]);
  }
}