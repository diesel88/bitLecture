package kr.co.mlec.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.Controller;
import org.springframework.web.ModelAndView;
import org.springframework.web.RequestMapping;

import com.google.gson.Gson;

import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.repository.vo.PageResultVO;
import kr.co.mlec.repository.vo.PageVO;

@Controller
public class BoardController {
	private BoardMapper mapper;
	
	public BoardController() {
		mapper = new BoardMapper();
	}
	
	@RequestMapping("/board/list1.do")
	public ModelAndView list1(PageVO page) throws Exception {
		// 목록 데이터
		List<BoardVO> list = mapper.selectBoard(page);
		// 페이징을 위한 전체 게시물 개수 조회
		int count = mapper.selectBoardCount(page);
		// 마지막 페이지
//		int lastPage = (count % 10 == 0) ? count / 10 : count / 10 + 1;
		int lastPage = (int)Math.ceil(count / 10d);
		
		// 이동되는 페이지 : /jsp/board/list1.jsp
		ModelAndView mav = new ModelAndView("/board/list1");
		mav.addObject("list", list);
		mav.addObject("count", count);
		
		// 마지막 페이지 표시
		mav.addObject("lastPage", lastPage);
		// 화면에서 현재 페이지 처리하기
		mav.addObject("pageNo", page.getPageNo());
		
		return mav;
	}
	@RequestMapping("/board/list2.do")
	public ModelAndView list2(PageVO page) throws Exception {
		List<BoardVO> list = mapper.selectBoard(page);
		int count = mapper.selectBoardCount(page);
		int lastPage = (int)Math.ceil(count / 10d);
		
		int pageNo = page.getPageNo();
		
		ModelAndView mav = new ModelAndView("/board/list2");
		mav.addObject("list", list);
		mav.addObject("count", count);
		
		mav.addObject("lastPage", lastPage);
		mav.addObject("pageNo", pageNo);
		
		
		// 페이지 탭과 연관된 정보
		int tabSize = 10;
		int currTab = (pageNo - 1) / tabSize + 1;
		int beginPage = (currTab - 1) * tabSize + 1;
		int endPage = (currTab * tabSize > lastPage) ? lastPage : currTab * tabSize;
		boolean prev = beginPage != 1;
		boolean next = endPage != lastPage;
		mav.addObject("beginPage", beginPage);
		mav.addObject("endPage", endPage);
		mav.addObject("prev", prev);
		mav.addObject("next", next);
		
		return mav;
	}
	
	
	@RequestMapping("/board/list3.do")
	public ModelAndView list3(PageVO page) throws Exception {
		List<BoardVO> list = mapper.selectBoard(page);
		int count = mapper.selectBoardCount(page);
		int pageNo = page.getPageNo();
		
		ModelAndView mav = new ModelAndView("/board/list3");
		mav.addObject("list", list);
		mav.addObject("count", count);
		mav.addObject("pageResult", new PageResultVO(pageNo, count));
		
		return mav;
	}
	@RequestMapping("/board/list4.do")
	public ModelAndView list4(PageVO page) throws Exception {
		List<BoardVO> list = mapper.selectBoard(page);
		int count = mapper.selectBoardCount(page);
		int pageNo = page.getPageNo();
		
		ModelAndView mav = new ModelAndView("/board/list4");
		mav.addObject("list", list);
		mav.addObject("count", count);
		mav.addObject("pageResult", new PageResultVO(pageNo, count));
		
		return mav;
	}
	@RequestMapping("/board/list5.do")
	public ModelAndView list5(PageVO page) throws Exception {
		List<BoardVO> list = mapper.selectBoard(page);
		int count = mapper.selectBoardCount(page);
		int pageNo = page.getPageNo();
		
		ModelAndView mav = new ModelAndView("/board/list5");
		mav.addObject("list", list);
		mav.addObject("pageResult", new PageResultVO(pageNo, count));
		
		return mav;
	}
	@RequestMapping("/board/list6.do")
	public String list6(PageVO page) throws Exception {
		List<BoardVO> list = mapper.selectBoard(page);
		int count = mapper.selectBoardCount(page);
		int pageNo = page.getPageNo();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("pageResult", new PageResultVO(pageNo, count));
		
		return "ajax:" + new Gson().toJson(map);
	}
}
