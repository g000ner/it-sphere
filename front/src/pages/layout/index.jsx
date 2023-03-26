import { Card } from '../../component/card-post';
import SearchBar from '../../component/search';
import style from './style.module.scss';

const Layout = () => {
return (
    <div className={style.Layout}>
        <SearchBar/>
        <Card/>
        <Card/>
        <Card/>
    </div>
    );
};

export default Layout;