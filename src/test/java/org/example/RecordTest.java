package org.example;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

public class RecordTest
{

  @Test
  public void recordTest() {
    var javaClasses = new ClassFileImporter().importPackages("org.example");

    classes().that()
        .haveNameMatching("(.*)Record")
        .should()
        .beRecords()
        .because("they should be simple data structures")
        .check(javaClasses);
  }
}
