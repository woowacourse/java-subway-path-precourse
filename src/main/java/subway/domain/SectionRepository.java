package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.exception.SubwayException;

public class SectionRepository {

    private static List<Section> sections = new ArrayList<>();

    private static void initialSections(){
        sections.add(new Section("교대역","강남역",2,3));
        sections.add(new Section("강남역","역삼역",2,3));
        sections.add(new Section("교대역","남부터미널역",3,2));
        sections.add(new Section("남부터미널역","양재역",6,5));
        sections.add(new Section("양재역","매봉역",1,1));
        sections.add(new Section("강남역","양재역",2,8));
        sections.add(new Section("양재역","양재시민의숲역",10,3));
    }

    public static List<Section> sections() {
        if(sections.isEmpty()){
            initialSections();
        }
        return Collections.unmodifiableList(sections);
    }

    public static Section findSection(String startName, String endName) {
        return sections.stream()
            .filter(section -> section.isSection(startName,endName))
            .findFirst()
            .orElseThrow(() -> new SubwayException("없는 구간입니다."));
    }




}
