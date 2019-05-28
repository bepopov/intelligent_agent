package ru.kpfu.itis.group11501.popov.intelligent_agent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermCount {

    private String term;

    private String docId;

    private Integer termCount;

}
