package com.android.basics.di;

import com.android.basics.domain.interactor.todo.AddTodoInteractor;
import com.android.basics.domain.interactor.todo.DeleteTodoInteractor;
import com.android.basics.domain.interactor.todo.EditTodoInteractor;
import com.android.basics.domain.interactor.todo.GetTodoListInteractor;
import com.android.basics.domain.interactor.user.AuthenticateUserInteractor;
import com.android.basics.domain.interactor.user.RegisterUserInteractor;
import com.android.basics.presentation.TodoCoordinator;

public class PresentationModule {

    private ApplicationComponent applicationComponent;

    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

    public TodoCoordinator provideNavigator() {
        return new TodoCoordinator(applicationComponent.navigator());
    }

    public RegisterUserInteractor provideRegisterUser() {
        return new RegisterUserInteractor(
                applicationComponent.userRepository(),
                applicationComponent.getApplicationModule().provideThreadExecutor(),
                applicationComponent.getApplicationModule().ProvidePostExecutionThread()
        );
    }

    public AuthenticateUserInteractor provideAuthenticateUser() {
        return new AuthenticateUserInteractor(
                applicationComponent.userRepository(),
                applicationComponent.getApplicationModule().provideThreadExecutor(),
                applicationComponent.getApplicationModule().ProvidePostExecutionThread()
        );
    }

    public GetTodoListInteractor provideGetTodoList() {
        return new GetTodoListInteractor(
                applicationComponent.todoRepository(),
                applicationComponent.getApplicationModule().provideThreadExecutor(),
                applicationComponent.getApplicationModule().ProvidePostExecutionThread()
        );
    }

    public AddTodoInteractor provideAddTodo() {
        return new AddTodoInteractor(
                applicationComponent.todoRepository(),
                applicationComponent.getApplicationModule().provideThreadExecutor(),
                applicationComponent.getApplicationModule().ProvidePostExecutionThread()
        );
    }

    public EditTodoInteractor provideEditTodoInteractor() {
        return new EditTodoInteractor(
                applicationComponent.todoRepository(),
                applicationComponent.getApplicationModule().provideThreadExecutor(),
                applicationComponent.getApplicationModule().ProvidePostExecutionThread()
        );
    }

    public DeleteTodoInteractor provideDeleteTodoInteractor() {
        return new DeleteTodoInteractor(
                applicationComponent.todoRepository(),
                applicationComponent.getApplicationModule().provideThreadExecutor(),
                applicationComponent.getApplicationModule().ProvidePostExecutionThread()
        );
    }

}
