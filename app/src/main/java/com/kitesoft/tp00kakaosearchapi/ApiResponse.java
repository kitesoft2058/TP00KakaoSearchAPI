package com.kitesoft.tp00kakaosearchapi;

import java.util.List;

public class ApiResponse {
    public MetaVO meta;
    public List<DocumentVO> documents;
}

class MetaVO{
    int total_count;
    int pageable_count;
    boolean is_end;
}

class DocumentVO{
    String id;
    String place_name;
    String category_name;
    String phone;
    String road_address_name;
    String x;
    String y;
    String place_url;
}
