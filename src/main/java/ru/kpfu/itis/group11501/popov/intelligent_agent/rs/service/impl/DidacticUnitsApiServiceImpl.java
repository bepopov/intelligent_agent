package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.DidacticUnit;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListDidacticUnit;
import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service.DidacticUnitsApiService;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.SearchService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DidacticUnitsApiServiceImpl implements DidacticUnitsApiService {

    private SearchService searchService;

    public DidacticUnitsApiServiceImpl(SearchService searchService) {
        this.searchService = searchService;
    }

    @Override
    public ResultListDidacticUnit getDidacticUnits(String searchText) {
        List<DidacticUnit> didacticUnits = searchService
                .searchGrouped(searchText,
                        ru.kpfu.itis.group11501.popov.intelligent_agent.model.DidacticUnit.class,
                        ru.kpfu.itis.group11501.popov.intelligent_agent.model.DidacticUnitGroup.class)
                .stream().map(doc -> {
                    DidacticUnit didacticUnit = new DidacticUnit();
                    didacticUnit.setName(doc.getContent());
                    didacticUnit.setId(UUID.fromString(doc.getId()));
                    return didacticUnit;
                }).collect(Collectors.toList());
        ResultListDidacticUnit resultList = new ResultListDidacticUnit();
        resultList.setItems(didacticUnits);
        return resultList;
    }
}
