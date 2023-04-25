import { Card } from '../../component/card-post';
import { Header } from '../../component/header';
import SearchBar from '../../component/search';
import style from './style.module.scss';
import axios from 'axios';
import {useEffect, useState} from 'react';

const Layout = () => {
    const [posts, setPosts] = useState([]);
    const [searchQuery, setSearchQuery] = useState('');

    useEffect(() => {
        async function getPosts() {
          const gottenPosts = await axios.get('http://localhost:8080/movies');
          return gottenPosts.data;
        }
        getPosts().then(data => setPosts(data));
      }, []);

    useEffect(() => {
        async function searchPost() {
          const gottenPosts = await axios.get('http://localhost:8080/movies?title_like=' + searchQuery);
          return gottenPosts.data;
        }
        searchPost().then(data => setPosts(data));
      }, [searchQuery]);


return (
    <div className={style.Layout}>
        <Header/>
        <SearchBar value={searchQuery} onChange={e => setSearchQuery(e.target.value)} />
        {/* <Card post={post} key ={post.id}/> */}
        <Card/>
        <Card/>
        <Card/>
        <Card/>
        <Card/>
        <Card/>
    </div>
    );
};

export default Layout;