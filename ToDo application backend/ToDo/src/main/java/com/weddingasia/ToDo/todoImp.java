package com.weddingasia.ToDo;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/todo")
public class todoImp implements todoTask {

	todoService service = new todoService();
	
	@POST
	@Path("/addTask")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public todoBean addTask(todoBean bean) {
		service.addtask(bean);
		return bean;
	}

	@POST
	@Path("/editTask")
	@Consumes(MediaType.APPLICATION_JSON)
	@Override
	public void editTask(todoBean bean) {
		
		service.editTask(bean);
		
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<todoBean> getAllTask() {
		return service.getAllTask();
	}

}
