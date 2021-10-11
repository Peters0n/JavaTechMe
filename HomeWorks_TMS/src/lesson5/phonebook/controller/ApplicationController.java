package lesson5.phonebook.controller;



import lesson5.phonebook.entity.Application;
import lesson5.phonebook.dao.ApplicationDAO;
import lesson5.phonebook.mapper.ApplicationMapper;
import lesson5.phonebook.marshaller.ApplicationMarshaller;
import lesson5.phonebook.storage.FileStorage;

import java.util.Collections;
import java.util.List;

public class ApplicationController implements IController {
    @Override
    public void process(List<String> arguments) {
        var storage = new FileStorage<Application>("./applications.txt");
//        storage.setEntityClass(Application.class);
        storage.setMarshaller(new ApplicationMarshaller());

        var dao = new ApplicationDAO(Collections.singletonList(storage));// объект сторадж ложится коллекцию, как лист
        switch (arguments.get(0).replace("application/", "")) {
            case "generate" : {
                var mapper = new ApplicationMapper();
                for (int i = 0; i < 15; i++) {
                    dao.save(mapper.toCreateEntity(arguments));
                }
            }
            case "list" : {
                var status = Integer.parseInt(arguments.get(1));
                if (!Application.STATUSES.contains(status)) {
                    throw new IllegalArgumentException("wrong status: " + status);
                }

                var entities = dao.findAll();
                for (Application entity : entities) {
                    if (status == -1 || entity.getStatus() == status) {
                        System.out.println(entity);
                    }
                }
            }
            case "save" : {
                Application application;
                var mapper = new ApplicationMapper();
                if(arguments.size()==7){
                    application = mapper.toUpdateEntity(arguments);
                    var list = dao.findAll();
                    dao.deleteFile();
                    for(int i = 0; i < list.size(); i++){ // замена строки с одинаковым id на новую с таким же id
                        if(list.get(i).getId().equals(Integer.parseInt(arguments.get(1)))){
                            list.remove(i);// удаляем строку i-ю, если id с строке совпадает с 1м аргументом args
                            list.add(application); //добавляем мапенные аргументы из args вместо удаленной строки
                        }
                        dao.save(list.get(i));
                    }


                }else{
                    application = mapper.toCreateEntity(arguments);// если нету строки с таким id, записываем i-ю строку в файл
                    dao.save(application);
                }




            }
            case "done" : {}
        }
    }
}
