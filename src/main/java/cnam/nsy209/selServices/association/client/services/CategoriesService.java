package cnam.nsy209.selServices.association.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cnam.nsy209.selServices.association.shared.exception.AlReadyExistException;
import cnam.nsy209.selServices.association.shared.exception.DoNotExistException;
import cnam.nsy209.selServices.association.shared.exception.EmptyException;
import cnam.nsy209.selServices.association.shared.localDto.CategoryLocalDto;

@RemoteServiceRelativePath("CategoriesService")
public interface CategoriesService extends RemoteService {
	public List<CategoryLocalDto> add(CategoryLocalDto category) throws AlReadyExistException,EmptyException;
	public List<CategoryLocalDto> getCategories();
	public List<CategoryLocalDto> delete(CategoryLocalDto category) throws DoNotExistException;
}
