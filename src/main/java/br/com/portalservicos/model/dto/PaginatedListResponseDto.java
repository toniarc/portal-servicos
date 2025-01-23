package br.com.portalservicos.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PaginatedListResponseDto<T> {

    private int totalPages;
    private long totalElements;
    private int currentPage;
    private List<T> content;

    public PaginatedListResponseDto(){
    }

    public PaginatedListResponseDto(int pageNumber, int pageSize, long totalElements, List<T> content) {
        super();
        this.totalPages = pageSize == 0 ? 1 : (int) Math.ceil((double) totalElements / (double) pageSize);
        this.totalElements = totalElements;
        this.content = content;
        this.currentPage = pageNumber;
    }

    public static <T> PaginatedListResponseDto<T> newPaginatedListResponseDto(int pageNumber, int pageSize, long totalElements, List<T> content) {
        PaginatedListResponseDto<T> paginatedListResponse = new PaginatedListResponseDto<>();
        paginatedListResponse.setTotalPages(pageSize == 0 ? 1 : (int) Math.ceil((double) totalElements / (double) pageSize));
        paginatedListResponse.setTotalElements(totalElements);
        paginatedListResponse.setContent(content);
        paginatedListResponse.setCurrentPage(pageNumber);
        return paginatedListResponse;
    }
}

