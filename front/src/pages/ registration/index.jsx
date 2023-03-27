import style from './style.module.scss';
import {Link, useNavigate, useParams} from 'react-router-dom';

const Registration = () => {
return (
    <div className={style.RegistrationBox}>
    <div className={style.Registration}>
        <h1 className={style.Title}>Регистрация</h1>
         <form className={style.Form}>
          <h2 className={style.FormName}> Email </h2>
          <input
            type="text"
            className={style.Form__input}
            // value={formState.title}
            name ={'title'}
            // onChange={onChangeForm}
            placeholder="Введите ваш email"
            required
          />          
          <h2 className={style.FormName}> Логин </h2>
          <input
            type="text"
            className={style.Form__input}
            // value={formState.title}
            name ={'title'}
            // onChange={onChangeForm}
            placeholder="Введите логин"
            required
          />          
          <h2 className={style.FormName}> Пароль </h2>
          <input
            type="text"
            className={style.Form__input}
            // value={formState.title}
            name ={'title'}
            // onChange={onChangeForm}
            placeholder="Введите пароль"
            required
          />
            <button className={style.AddUser} type="submit" >
            {' '}
            Зарегистироваться
          </button>
          </form>
    </div>
    <div className={style.Entry}>
        <div className={style.Text}>Уже зарегестрированы?
        <Link to="/entry">
            <button className={style.EntryGo}>Войдите</button>
        </Link>
        </div>
    </div>
    </div>
    );
};

export default Registration;