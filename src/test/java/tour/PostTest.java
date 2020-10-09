package tour;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tour.app.dto.PostContentDTO;
import com.tour.app.dto.PostDTO;

@RunWith(SpringJUnit4ClassRunner.class) // 이 클래스를 테스트 클래스로 사용하겠다는 설정
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" }) // contextConfiguration은 어플리케이션 설정과, 디스패처 서블릿의 xml설정을 디렉토리에서 가져오겠다는 어노테이션이다.
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class PostTest {
	@Autowired
	WebApplicationContext context;
	
	private MockMvc mock;
	private ObjectMapper mapper = new ObjectMapper();
	private PostDTO post = new PostDTO();
	
	//private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	// https://www.lesstif.com/java/mockmvc-result-14090472.html
	
	@Before
	public void beforeTest() {		
		mock = MockMvcBuilders.webAppContextSetup(context).build();
		
		//PostDTO post = new PostDTO();
		post.setBoardTypeId(1);
		//post.setCreateDate(new Date(System.currentTimeMillis()));
		post.setHitsNumber(0);
		post.setMemberId("qkrwlgus5832");
		post.setTitle("게시글 junit 테스트 입니다. 잘 insert 돼길 바래요");
		post.setNotifyFlag(false);
		
		PostContentDTO postContent = new PostContentDTO();
		postContent.setContent("게시글 테스트입니다. 잘 insert 돼길 바래요");
		postContent.setBoardTypeId(1);
		
		post.setPostContent(postContent);
	}
	
	@Test
	 public void test1listTest() throws Exception{        
        mock.perform(get("/post/list").param("boardType", "1")).andExpect(status().isOk()).andDo(print());
        mock.perform(get("/post/1")).andExpect(status().isOk()).andDo(print());
        mock.perform(get("/post/2")).andExpect(status().isOk()).andDo(print());
        mock.perform(get("/post/3")).andExpect(status().isOk()).andDo(print());
        mock.perform(get("/post/4")).andExpect(status().isOk()).andDo(print());
        mock.perform(get("/post/5")).andExpect(status().isOk()).andDo(print());
  
    }
		
	public PostDTO getLastAddedPost() throws Exception{
		MvcResult result = mock
				.perform(get("/post/list").param("boardType", Integer.toBinaryString(post.getBoardTypeId())))
				.andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		ArrayList<PostDTO> postList = new ArrayList<PostDTO>();
		postList = mapper.readValue(content, new TypeReference<ArrayList<PostDTO>>() {
		});

		PostDTO last = postList.get(postList.size() - 1);
		return last;
	}
	
	@Test
	public void test2insertTest() throws Exception{
		System.out.println("insert test start");
		
		mock.perform(post("/post/").contentType(MediaType.APPLICATION_JSON_VALUE).content(mapper.writeValueAsString(post))).andExpect(status().isOk());

		PostDTO last = getLastAddedPost();
		
		post.setPostId(last.getPostId());
		post.getPostContent().setPostId(last.getPostId());
		post.setCreateDate(last.getCreateDate());
		
		assertTrue(post.equals(last));

	}
	
	@Test
	public void test3modifyTest() throws Exception {
		System.out.println("modify test start");
		PostDTO before = getLastAddedPost();
		
		before.setTitle("타이틀 수정 테스트");
		before.getPostContent().setContent("내용 수정 테스트");
		mock.perform(put("/post/").contentType(MediaType.APPLICATION_JSON_VALUE).content(mapper.writeValueAsString(before))).andExpect(status().isOk());
		PostDTO after = getLastAddedPost() ;
		
		assertTrue(before.equals(after));
	}
	
	@Test
	public void test4deleteTest() throws Exception{
		System.out.println("delete test start");
		PostDTO last = getLastAddedPost();
		mock.perform(delete("/post/").contentType(MediaType.APPLICATION_JSON_VALUE).content(mapper.writeValueAsString(last))).andExpect(status().isOk());
		assertFalse(getLastAddedPost().equals(last));		
	}


}
