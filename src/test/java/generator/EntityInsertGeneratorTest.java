package generator;

import configuration.MigrationConfig;
import configuration.ProcessorConfigEntry;
import graql.lang.pattern.variable.ThingVariable;
import org.junit.Assert;
import org.junit.Test;

import static util.Util.getAbsPath;
import java.util.ArrayList;
import java.util.HashMap;

import static test.TestUtil.getData;

public class EntityInsertGeneratorTest {

    private final String keyspaceName = "grakn_migrator_test";
    private final String asp = getAbsPath("src/test/resources/genericTests/schema-test.gql");
    private final String adcp = getAbsPath("src/test/resources/genericTests/dataConfig-test.json");
    private final String gcp = getAbsPath("src/test/resources/genericTests/processorConfig-test.json");
    private final String entity1dp = getAbsPath("src/test/resources/genericTests/entity1-test-data.tsv");
    private final String entity2dp = getAbsPath("src/test/resources/genericTests/entity2-test-data.tsv");
    private final String entity3dp = getAbsPath("src/test/resources/genericTests/entity3-test-data.tsv");
    private final MigrationConfig migrationConfig = new MigrationConfig("localhost:1729",keyspaceName, asp, adcp, gcp);
    private final HashMap<String, ArrayList<ProcessorConfigEntry>> genConf = migrationConfig.getProcessorConfig();

    @Test
    public void graknEntityQueryFromRowTest() {

        EntityInsertGenerator testEntityInsertGenerator = new EntityInsertGenerator(migrationConfig.getDataConfig().get("entity1"), genConf.get("processors").get(0), 0);

        ArrayList<String> rows = getData(entity1dp);
        String header = rows.get(0);
        rows = new ArrayList<>(rows.subList(1, rows.size()));

        GeneratorStatements results = testEntityInsertGenerator.graknEntityInsert(rows, header, 1);

        String tc0 = "$e isa entity1, has entity1-id \"entity1id0\", has entity1-name \"entity1name0\", has entity1-exp \"entity1id0exp0\"";
        Assert.assertEquals(tc0, results.getInserts().get(0).toString());

        String tc1 = "$e isa entity1, has entity1-id \"entity1id1\", has entity1-name \"entity1name1\", has entity1-exp \"entity1id1exp11\", has entity1-exp \"entity1id1exp12\"";
        Assert.assertEquals(tc1, results.getInserts().get(1).toString());

        String tc2 = "$e isa entity1, has entity1-id \"entity1id2\", has entity1-name \"entity1name2\", has entity1-exp \"entity1id2exp21\", has entity1-exp \"entity1id2exp22\", has entity1-exp \"entity1id2exp23\"";
        Assert.assertEquals(tc2, results.getInserts().get(2).toString());

        String tc3 = "$e isa entity1, has entity1-id \"entity1id3\", has entity1-name \"entity1name3\"";
        Assert.assertEquals(tc3, results.getInserts().get(3).toString());

        String tc4 = "$e isa entity1, has entity1-id \"entity1id4\", has entity1-name \"entity1name4\"";
        Assert.assertEquals(tc4, results.getInserts().get(4).toString());

        String tc5 = "$e isa entity1, has entity1-id \"entity1id5\", has entity1-name \"entity1name5\"";
        Assert.assertEquals(tc5, results.getInserts().get(5).toString());

        String tc6 = "$e isa entity1, has entity1-id \"entity1id6\", has entity1-name \"entity1name6\"";
        Assert.assertEquals(tc6, results.getInserts().get(6).toString());

        String tc7 = "$e isa entity1, has entity1-id \"entity1id7\", has entity1-name \"entity1name7\"";
        Assert.assertEquals(tc7, results.getInserts().get(7).toString());

        String tc8 = "$e isa entity1, has entity1-id \"entity1id8\", has entity1-name \"entity1name8\"";
        Assert.assertEquals(tc8, results.getInserts().get(8).toString());

        String tc9 = "$e isa entity1, has entity1-id \"entity1id9\", has entity1-name \"entity1name9\"";
        Assert.assertEquals(tc9, results.getInserts().get(9).toString());

        String tc10 = "$e isa entity1, has entity1-id \"entity1id10\", has entity1-name \"entity1name10\"";
        Assert.assertEquals(tc10, results.getInserts().get(10).toString());

        String tc11 = "$e isa entity1, has entity1-id \"entity1id11\", has entity1-name \"entity1name11\"";
        Assert.assertEquals(tc11, results.getInserts().get(11).toString());

        String tc12 = "$e isa entity1, has entity1-id \"entity1id12\", has entity1-name \"entity1name12\"";
        Assert.assertEquals(tc12, results.getInserts().get(12).toString());

        String tc13 = "$e isa entity1, has entity1-id \"entity1id13\", has entity1-name \"entity1name13\"";
        Assert.assertEquals(tc13, results.getInserts().get(13).toString());

        String tc14 = "$e isa entity1, has entity1-id \"entity1id14\", has entity1-name \"entity1name14\"";
        Assert.assertEquals(tc14, results.getInserts().get(14).toString());

        String tc15 = "$e isa entity1, has entity1-id \"entity1id15\", has entity1-name \"entity1name15\"";
        Assert.assertEquals(tc15, results.getInserts().get(15).toString());

        String tc16 = "$e isa entity1, has entity1-id \"entity1id16\", has entity1-name \"entity1name16\", has entity1-name \"entity1name16-2\"";
        Assert.assertEquals(tc16, results.getInserts().get(16).toString());

        String tc17 = "$e isa entity1, has entity1-id \"entity1id17\", has entity1-name \"entity1name17\"";
        Assert.assertEquals(tc17, results.getInserts().get(17).toString());

        String tc18 = "$e isa entity1, has entity1-id \"entity1id18\", has entity1-name \"entity1name18\"";
        Assert.assertEquals(tc18, results.getInserts().get(18).toString());

        String tc19 = "$e isa entity1, has entity1-id \"entity1id19\", has entity1-name \"entity1name19\"";
        Assert.assertEquals(tc19, results.getInserts().get(19).toString());

        Assert.assertEquals(20, results.getInserts().size());
    }



    @Test
    public void graknEntityQueryFromRowWithBoolAndDoubleTest() {
        EntityInsertGenerator testEntityInsertGenerator = new EntityInsertGenerator(migrationConfig.getDataConfig().get("entity2"), genConf.get("processors").get(1), 0);

        ArrayList<String> rows = getData(entity2dp);
        String header = rows.get(0);
        rows = new ArrayList<>(rows.subList(1, rows.size()));

        GeneratorStatements results = testEntityInsertGenerator.graknEntityInsert(rows, header, 1);

        String tc0 = "$e isa entity2, has entity2-id \"entity2id0\", has entity2-bool true, has entity2-double 0.0";
        Assert.assertEquals(tc0, results.getInserts().get(0).toString());

        String tc1 = "$e isa entity2, has entity2-id \"entity2id1\", has entity2-bool false, has entity2-double 1.1, has entity2-double 11.11";
        Assert.assertEquals(tc1, results.getInserts().get(1).toString());

        String tc2 = "$e isa entity2, has entity2-id \"entity2id2\", has entity2-bool true, has entity2-double 2.2";
        Assert.assertEquals(tc2, results.getInserts().get(2).toString());

        String tc3 = "$e isa entity2, has entity2-id \"entity2id3\", has entity2-bool false, has entity2-double -3.3";
        Assert.assertEquals(tc3, results.getInserts().get(3).toString());

        String tc4 = "$e isa entity2, has entity2-id \"entity2id4\", has entity2-double 4.0";
        Assert.assertEquals(tc4, results.getInserts().get(4).toString());

        String tc5 = "$e isa entity2, has entity2-id \"entity2id5\"";
        Assert.assertEquals(tc5, results.getInserts().get(5).toString());

        String tc6 = "$e isa entity2, has entity2-id \"entity2id6\"";
        Assert.assertEquals(tc6, results.getInserts().get(6).toString());

        String tc7 = "$e isa entity2, has entity2-id \"entity2id7\"";
        Assert.assertEquals(tc7, results.getInserts().get(7).toString());

        String tc8 = "$e isa entity2, has entity2-id \"entity2id8\"";
        Assert.assertEquals(tc8, results.getInserts().get(8).toString());

        String tc9 = "$e isa entity2, has entity2-id \"entity2id9\"";
        Assert.assertEquals(tc9, results.getInserts().get(9).toString());

        String tc10 = "$e isa entity2, has entity2-id \"entity2id10\"";
        Assert.assertEquals(tc10, results.getInserts().get(10).toString());

        Assert.assertEquals(11, results.getInserts().size());
    }

    @Test
    public void graknEntityQueryFromRowWithLongTest() {

        EntityInsertGenerator testEntityInsertGenerator = new EntityInsertGenerator(migrationConfig.getDataConfig().get("entity3"), genConf.get("processors").get(2), 0);

        ArrayList<String> rows = getData(entity3dp);
        String header = rows.get(0);
        rows = new ArrayList<>(rows.subList(1, rows.size()));

        GeneratorStatements results = testEntityInsertGenerator.graknEntityInsert(rows, header, 1);

        String tc0 = "$e isa entity3, has entity3-id \"entity3id0\", has entity3-int 0";
        Assert.assertEquals(tc0, results.getInserts().get(0).toString());

        String tc1 = "$e isa entity3, has entity3-id \"entity3id1\", has entity3-int 1, has entity3-int 11";
        Assert.assertEquals(tc1, results.getInserts().get(1).toString());

        String tc2 = "$e isa entity3, has entity3-id \"entity3id2\", has entity3-int 2";
        Assert.assertEquals(tc2, results.getInserts().get(2).toString());

        String tc3 = "$e isa entity3, has entity3-id \"entity3id3\", has entity3-int -3";
        Assert.assertEquals(tc3, results.getInserts().get(3).toString());

        String tc4 = "$e isa entity3, has entity3-id \"entity3id4\"";
        Assert.assertEquals(tc4, results.getInserts().get(4).toString());

        String tc5 = "$e isa entity3, has entity3-id \"entity3id5\"";
        Assert.assertEquals(tc5, results.getInserts().get(5).toString());

        String tc6 = "$e isa entity3, has entity3-id \"entity3id6\"";
        Assert.assertEquals(tc6, results.getInserts().get(6).toString());

        String tc7 = "$e isa entity3, has entity3-id \"entity3id7\"";
        Assert.assertEquals(tc7, results.getInserts().get(7).toString());

        String tc8 = "$e isa entity3, has entity3-id \"entity3id8\"";
        Assert.assertEquals(tc8, results.getInserts().get(8).toString());

        String tc9 = "$e isa entity3, has entity3-id \"entity3id9\"";
        Assert.assertEquals(tc9, results.getInserts().get(9).toString());

        String tc10 = "$e isa entity3, has entity3-id \"entity3id10\"";
        Assert.assertEquals(tc10, results.getInserts().get(10).toString());

        Assert.assertEquals(11, results.getInserts().size());
    }
}