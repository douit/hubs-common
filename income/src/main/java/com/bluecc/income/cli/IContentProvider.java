package com.bluecc.income.cli;

import java.util.List;

public interface IContentProvider {
    String getName();

    String getData();

    List<Object> getChildren();
}
