import style from './style.module.scss';

const Entry = () => {
return (
    <div className={style.EntryBox}>
    <div className={style.Entry}>
        <h1 className={style.Title}>Bход</h1>
         <form className={style.Form}>         
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
            Войти
          </button>
          </form>
    </div>
    </div>
    );
};

export default Entry;