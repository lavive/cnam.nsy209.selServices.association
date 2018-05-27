package cnam.nsy209.selServices.association.server.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cnam.nsy209.selServices.association.client.services.CategoriesService;
import cnam.nsy209.selServices.association.server.callable.AddCategoryCallable;
import cnam.nsy209.selServices.association.server.callable.DeleteCategoryCallable;
import cnam.nsy209.selServices.association.server.callable.GetCategoriesCallable;
import cnam.nsy209.selServices.association.server.callable.WebServiceCallable;
import cnam.nsy209.selServices.association.server.dto.CategoriesDto;
import cnam.nsy209.selServices.association.server.dto.CategoryDto;
import cnam.nsy209.selServices.association.shared.exception.AlReadyExistException;
import cnam.nsy209.selServices.association.shared.exception.DoNotExistException;
import cnam.nsy209.selServices.association.shared.exception.EmptyException;
import cnam.nsy209.selServices.association.shared.localDto.CategoryLocalDto;
import cnam.nsy209.selServices.association.shared.localDto.transform.LocalToRemote;
import cnam.nsy209.selServices.association.shared.localDto.transform.RemoteToLocal;
/** 
 * 
 * Class Implementing async services declared at the client package
 * Execute the category Service call
 * 
 * @author lavive
 *
 */
@SuppressWarnings("serial")
public class CategoriesServiceImpl extends RemoteServiceServlet implements CategoriesService {

	@Override
	public List<CategoryLocalDto> add(CategoryLocalDto category) throws AlReadyExistException,EmptyException{
		if(category.getName() == null || category.getName().trim().equals(""))
			throw new EmptyException();
		
		List<CategoryLocalDto> categories = getCategories();
		for(CategoryLocalDto cat:categories) {
			if(cat.getName().equals(category.getName())) throw new AlReadyExistException(cat.getName());
		}

		CategoriesDto categoriesResult = null;
		try {
			CategoryDto categoryRemote = LocalToRemote.toRemoteCategory(category);
			new WebServiceCallable<Void>(new AddCategoryCallable(categoryRemote)).call();
			categoriesResult = new WebServiceCallable<CategoriesDto>(new GetCategoriesCallable()).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<CategoryLocalDto> categoriesLocal = new ArrayList<CategoryLocalDto>();
		for(CategoryDto cat:categoriesResult.getCategories()) {
			categoriesLocal.add(RemoteToLocal.toLocalCategory(cat));
		}
		
		return categoriesLocal;
	}

	@Override
	public List<CategoryLocalDto> getCategories() {
		
		CategoriesDto categories = null;
		try {
			categories = new WebServiceCallable<CategoriesDto>(new GetCategoriesCallable()).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<CategoryLocalDto> categoriesLocal = new ArrayList<CategoryLocalDto>();
		for(CategoryDto category:categories.getCategories()) {
			categoriesLocal.add(RemoteToLocal.toLocalCategory(category));
		}
		
		return categoriesLocal;
	}

	@Override
	public List<CategoryLocalDto> delete(CategoryLocalDto category) throws DoNotExistException {
		if(category == null) throw new DoNotExistException();
		
		List<CategoryLocalDto> categories = getCategories();
		boolean exist = false;
		for(CategoryLocalDto cat:categories) {
			if(cat.getName().equals(category.getName())) exist = true;
		}
		if(!exist) throw new DoNotExistException();

		CategoriesDto newCategories = null;
		try {
			CategoryDto categoryRemote = LocalToRemote.toRemoteCategory(category);
			newCategories = new WebServiceCallable<CategoriesDto>(new DeleteCategoryCallable(categoryRemote)).call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<CategoryLocalDto> categoriesLocal = new ArrayList<CategoryLocalDto>();
		for(CategoryDto cat:newCategories.getCategories()) {
			categoriesLocal.add(RemoteToLocal.toLocalCategory(cat));
		}
		
		return categoriesLocal;
	}

}
