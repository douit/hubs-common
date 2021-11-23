package com.bluecc.content.dummy;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class DummyProducts {
    private static final Logger logger = LoggerFactory.getLogger(DummyProducts.class);
    public static void main(String[] args) {
        DummyProducts dummyProducts=new DummyProducts();
        dummyProducts.storeProduct();
    }

    void storeProduct(){
        logger.info(".. start");
        try (CqlSession session = CqlSession.builder().build()) {
            // 注释处理期间生成的类之一是InventoryMapperBuilder. 它允许您通过包装核心驱动程序会话来初始化映射器实例：
            // 映射器应该与应用程序中的会话具有相同的生命周期：在初始化时创建一次，然后重用。它是线程安全的。
            InventoryMapper inventoryMapper = new InventoryMapperBuilder(session).build();

            // 从映射器获取 DAO 实例并执行查询：
            ProductDao dao = inventoryMapper.productDao(CqlIdentifier.fromCql("inventory"));
            UUID id = UUID.randomUUID();
            dao.save(new Product(id, "Mechanical keyboard"));
            System.out.println("save ok.");

            Product retrievedProduct = dao.findById(id);
            System.out.printf("Retrieved %s%n", retrievedProduct);

            ImmutableProduct retrievedImmutableProduct = dao.getImmutable(id);
            System.out.printf("Retrieved %s%n", retrievedImmutableProduct);
        }
    }
}
