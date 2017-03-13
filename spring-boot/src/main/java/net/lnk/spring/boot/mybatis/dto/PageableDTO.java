package net.lnk.spring.boot.mybatis.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.github.pagehelper.Page;

/**
 * @author Ben
 * @memo 2017年3月2日
 */
public class PageableDTO<T> implements Serializable {

	public PageableDTO() {
		isFirstPage = false;
		isLastPage = false;
		hasPreviousPage = false;
		hasNextPage = false;
	}

	public PageableDTO(List<T> list) {
		this(list, 10);
	}

	public PageableDTO(List<T> list, int navigatePages) {
		isFirstPage = false;
		isLastPage = false;
		hasPreviousPage = false;
		hasNextPage = false;
		if (list instanceof Page) {
			Page<T> page = (Page<T>) list;
			pageNum = page.getPageNum();
			pageSize = page.getPageSize();
			pages = page.getPages();
			this.list = page;
			size = page.size();
			total = page.getTotal();
			if (size == 0) {
				startRow = 0;
				endRow = 0;
			} else {
				startRow = page.getStartRow() + 1;
				endRow = (startRow - 1) + size;
			}
		} else if (list instanceof Collection) {
			pageNum = 1;
			pageSize = list.size();
			pages = 1;
			this.list = list;
			size = list.size();
			total = list.size();
			startRow = 0;
			endRow = list.size() <= 0 ? 0 : list.size() - 1;
		}
		if (list instanceof Collection) {
			this.navigatePages = navigatePages;
			calcNavigatepageNums();
			calcPage();
			judgePageBoudary();
		}
	}

	public void initFromPageableResponse(PageableDTO<T> pageableDTO, List<T> replaceBeanList) {
		list = replaceBeanList;
		pageNum = pageableDTO.getPageNum();
		pageSize = pageableDTO.getPageSize();
		pages = pageableDTO.getPages();
		size = list.size();
		total = pageableDTO.getTotal();
		if (size == 0) {
			startRow = 0;
			endRow = 0;
		} else {
			startRow = pageableDTO.getStartRow() + 1;
			endRow = (startRow - 1) + size;
		}
		navigatePages = 8;
		calcNavigatepageNums();
		calcPage();
		judgePageBoudary();
	}

	public void initFromPage(List<T> list) {
		if (list instanceof Page) {
			Page<T> page = (Page<T>) list;
			pageNum = page.getPageNum();
			pageSize = page.getPageSize();
			pages = page.getPages();
			size = page.size();
			total = page.getTotal();
			if (size == 0) {
				startRow = 0;
				endRow = 0;
			} else {
				startRow = page.getStartRow() + 1;
				endRow = (startRow - 1) + size;
			}
		} else if (list instanceof Collection) {
			pageNum = 1;
			pageSize = list.size();
			pages = 1;
			this.list = list;
			size = list.size();
			total = list.size();
			startRow = 0;
			endRow = list.size() <= 0 ? 0 : list.size() - 1;
		}
		if (list instanceof Collection) {
			navigatePages = 10;
			calcNavigatepageNums();
			calcPage();
			judgePageBoudary();
		}
	}

	public void initFromPage(Page<T> page) {
		pageNum = page.getPageNum();
		pageSize = page.getPageSize();
		pages = page.getPages();
		size = page.size();
		total = page.getTotal();
		if (size == 0) {
			startRow = 0;
			endRow = 0;
		} else {
			startRow = page.getStartRow() + 1;
			endRow = (startRow - 1) + size;
		}
		navigatePages = 8;
		calcNavigatepageNums();
		calcPage();
		judgePageBoudary();
	}

	private void calcNavigatepageNums() {
		if (pages <= navigatePages) {
			navigatepageNums = new int[pages];
			for (int i = 0; i < pages; i++)
				navigatepageNums[i] = i + 1;

		} else {
			navigatepageNums = new int[navigatePages];
			int startNum = pageNum - navigatePages / 2;
			int endNum = pageNum + navigatePages / 2;
			if (startNum < 1) {
				startNum = 1;
				for (int i = 0; i < navigatePages; i++)
					navigatepageNums[i] = startNum++;

			} else if (endNum > pages) {
				endNum = pages;
				for (int i = navigatePages - 1; i >= 0; i--)
					navigatepageNums[i] = endNum--;

			} else {
				for (int i = 0; i < navigatePages; i++)
					navigatepageNums[i] = startNum++;

			}
		}
	}

	private void calcPage() {
		if (navigatepageNums != null && navigatepageNums.length > 0) {
			firstPage = navigatepageNums[0];
			lastPage = navigatepageNums[navigatepageNums.length - 1];
			if (pageNum > 1)
				prePage = pageNum - 1;
			if (pageNum < pages)
				nextPage = pageNum + 1;
		}
	}

	private void judgePageBoudary() {
		isFirstPage = pageNum == 1;
		isLastPage = pageNum == pages;
		hasPreviousPage = pageNum > 1;
		hasNextPage = pageNum < pages;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public boolean isIsFirstPage() {
		return isFirstPage;
	}

	public void setIsFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isIsLastPage() {
		return isLastPage;
	}

	public void setIsLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getNavigatePages() {
		return navigatePages;
	}

	public void setNavigatePages(int navigatePages) {
		this.navigatePages = navigatePages;
	}

	public int[] getNavigatepageNums() {
		return navigatepageNums;
	}

	public void setNavigatepageNums(int navigatepageNums[]) {
		this.navigatepageNums = navigatepageNums;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("PageInfo{");
		sb.append("pageNum=").append(pageNum);
		sb.append(", pageSize=").append(pageSize);
		sb.append(", size=").append(size);
		sb.append(", startRow=").append(startRow);
		sb.append(", endRow=").append(endRow);
		sb.append(", total=").append(total);
		sb.append(", pages=").append(pages);
		sb.append(", list=").append(list);
		sb.append(", firstPage=").append(firstPage);
		sb.append(", prePage=").append(prePage);
		sb.append(", nextPage=").append(nextPage);
		sb.append(", lastPage=").append(lastPage);
		sb.append(", isFirstPage=").append(isFirstPage);
		sb.append(", isLastPage=").append(isLastPage);
		sb.append(", hasPreviousPage=").append(hasPreviousPage);
		sb.append(", hasNextPage=").append(hasNextPage);
		sb.append(", navigatePages=").append(navigatePages);
		sb.append(", navigatepageNums=");
		if (navigatepageNums == null) {
			sb.append("null");
		} else {
			sb.append('[');
			for (int i = 0; i < navigatepageNums.length; i++)
				sb.append(i != 0 ? ", " : "").append(navigatepageNums[i]);

			sb.append(']');
		}
		sb.append('}');
		return sb.toString();
	}

	private static final long serialVersionUID = 1L;
	private int pageNum;
	private int pageSize;
	private int size;
	private int startRow;
	private int endRow;
	private long total;
	private int pages;
	private List<T> list;
	private int firstPage;
	private int prePage;
	private int nextPage;
	private int lastPage;
	private boolean isFirstPage;
	private boolean isLastPage;
	private boolean hasPreviousPage;
	private boolean hasNextPage;
	private int navigatePages;
	private int navigatepageNums[];

}
