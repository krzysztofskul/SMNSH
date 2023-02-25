package pl.krzysztofskul.initDB;

import java.util.List;

public interface InitDataGenerator<T> {
	
	List<T> initDataAndReturn();

}
