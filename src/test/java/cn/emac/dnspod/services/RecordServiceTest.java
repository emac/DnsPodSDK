package cn.emac.dnspod.services;

import cn.emac.dnspod.DnsPodConfig;
import cn.emac.dnspod.model.Record;
import cn.emac.dnspod.model.Status;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

public class RecordServiceTest extends BaseTest {

    @Test
    public void testExists() throws Exception {
        Assert.assertTrue(RecordService.exists(DnsPodConfig.getDomain_id(), ""));
        Assert.assertTrue(RecordService.exists(DnsPodConfig.getDomain_id(), "www"));
        Assert.assertFalse(RecordService.exists(DnsPodConfig.getDomain_id(), "mmm"));
    }

    @Test
    public void testCreate() throws Exception {
        Record record = new Record();
        record.setDomain_id(DnsPodConfig.getDomain_id());
        record.setSub_domain("test");
        record.setRecord_type("A");
        record.setRecord_line("默认");
        record.setValue("115.28.77.100");
        record.setMx("0");
        record.setTtl("600");
        Status status = RecordService.create(record);
        Assert.assertEquals("1", status.getCode());
    }

    @Test
    public void testList() throws Exception {
        Assert.assertEquals(1, RecordService.list(DnsPodConfig.getDomain_id(), "www").size());
        Assert.assertEquals(0, RecordService.list(DnsPodConfig.getDomain_id(), "mmm").size());
    }

    @Test
    public void testRemove() throws Exception {
        List<Record> list = RecordService.list(DnsPodConfig.getDomain_id(), "test");
        if (list.size() == 0) {
            return;
        }

        for (Record r : list) {
            Status status = RecordService.remove(r);
            Assert.assertEquals("1", status.getCode());
        }
    }
}