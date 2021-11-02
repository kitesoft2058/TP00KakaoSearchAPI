package com.kitesoft.tp00kakaosearchapi;

import java.util.Date;
import java.util.List;

public class ImageApiResponse {
    ImageMetaVO meta;
    List<ImageDocumentVO> documents;
}

class ImageMetaVO{
    int total_count;
    int pageable_count;
    boolean is_end;
}

class ImageDocumentVO{
    String collection;
    String thumbnail_url;
    String image_url;
    String display_sitename;
    String doc_url;
    //Date datetime;
    String datetime;
}
