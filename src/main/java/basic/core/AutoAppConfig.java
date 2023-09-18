package basic.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
        //basePackages = "basic.core.member",

        //앞서 설정한 예제는 유지하기(등록하지 않기) 위해서 해당 어노테이션 필터링(보통은 제외하지 않음)
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

}
