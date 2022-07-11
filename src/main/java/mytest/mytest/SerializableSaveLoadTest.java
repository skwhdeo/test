package mytest;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class MyServiceTest {

	@Test
	void test() throws ClassNotFoundException, IOException {
		SerializableService service = SerializableService.getInstace();
		service.load();
		service.print("-------------------");
		service.create("test", 10);
		service.create("test2", 10);
		service.enque("test", "msg1");
		service.enque("test", "msg2");
		service.deque("test");
		service.save();
		service.print("====================");
	}

}
