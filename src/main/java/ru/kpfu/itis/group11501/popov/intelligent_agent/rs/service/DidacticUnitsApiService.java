package ru.kpfu.itis.group11501.popov.intelligent_agent.rs.service;

import ru.kpfu.itis.group11501.popov.intelligent_agent.rs.model.ResultListDidacticUnit;

public interface DidacticUnitsApiService {

    ResultListDidacticUnit getDidacticUnits(String searchText);
}
