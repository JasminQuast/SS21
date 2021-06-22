
import { mount } from '@vue/test-utils'
import Note from './note.js';
global.axios = {
    get() { return Promise.resolve({ data: [] }) },
    post() { return Promise.resolve('value') }
}

test('shows greetings', () => {
    const wrapper = mount(Note, {
        props:{
            title:'hello'
        }
    });
    expect(wrapper.text()).toContain('hello');
})
